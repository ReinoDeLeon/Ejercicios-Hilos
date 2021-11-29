package parking;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Parking parking = new Parking(2);
		Car firstCar = new Car("3456-HKM", 2, parking, "Mustang");
		Car secondCar = new Car("4572-JLK", 2, parking, "Ferrari");
		Car thirdCar = new Car("3059-OPS", 2, parking, "BMW");
		
		System.out.printf("-------------Parking is open, %d spots free to park-------------\n", parking.getAvailableSpots());
		firstCar.start();
		secondCar.start();
		thirdCar.start();
		
		Thread.sleep(10000);
		
		firstCar.interrupt();
		secondCar.interrupt();
		thirdCar.interrupt();
		
		firstCar.join();
		secondCar.join();
		thirdCar.join();
		
		System.out.println("Parking just closed");
		
	}

}
