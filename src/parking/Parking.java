package parking;

public class Parking {

	private final int maxSpots;//Parking maximum capacity
	private int availableSpots;//Parking actual capacity
	
	


	public Parking(int _maxSpots) {
		super();
		maxSpots = _maxSpots;
		availableSpots = maxSpots;
	}
	
	
	//park function
	public synchronized void park(Car car) {
		//Meanwhile there aren't free spots we wait for a car to leave
		while (availableSpots == 0) {
			try {
				System.out.printf("Car %s awaiting empty spot\n", car.getEnrolment());
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//Once a spot is set free, we park and notify all others that the spot is taken
		availableSpots--;
		System.out.printf("\tCar %s has just parked, %d avaliable spots\n", car.getEnrolment(), availableSpots);
		notifyAll();
	}
	
	//Leave parking function
	public synchronized void leave(Car car) {
		//Once we leave we set free spots +1 and we notify all others that the spot is free
		availableSpots++;
		System.out.printf("Car %s has just left, %d avaliable spots\n", car.getEnrolment(), availableSpots);

		notifyAll();
	}
	
	public int getAvailableSpots() {
		return availableSpots;
	}
	
}
