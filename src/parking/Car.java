package parking;

public class Car extends Thread {
	private final int maxRandomWaitTime;
	private final Parking parking;
	private String enrolment;
	
	
	//Activate car in a loop to park
	@Override
	public void run() {
		while (true) {
			try {
				//Wait
				Thread.sleep((int) (Math.random()*maxRandomWaitTime));
				//If parking is available parks, else it waits inside Parking Class
				parking.park(this);
				//Wait parked
				Thread.sleep((int) (Math.random()*maxRandomWaitTime));
				//Leave the parking spot
				parking.leave(this);
			} catch (InterruptedException e) {
				System.out.printf("Car %s just left\n", enrolment);
				break;
			}
			
		}
	}

	//Constructor
	public Car(String _enrollment, int _maxRandomWaitTime, Parking _parking, String name) {
		super(name);
		enrolment = (_enrollment);
		maxRandomWaitTime = _maxRandomWaitTime * 1000;
		parking = _parking;
	}

	//Returns car Enrolment
	public String getEnrolment() {
		return enrolment;
	}


}
