package broker;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		Broker broker = new Broker(20);
		Client clientMaria = new Client("María", broker);
		Client clientJuan = new Client("Juan", broker);
		Client clientCeci = new Client("Cecilia", broker);
		Client clientMario = new Client("Mario", broker);

		//Start client thread
		clientMaria.start();
		clientCeci.start();
		clientJuan.start();
		clientMario.start();
		
		//Wait main thread
		broker.waitUntilNoSharesAvaliable();
		
		//Interrupt all client thread
		clientMaria.interrupt();
		clientJuan.interrupt();
		clientCeci.interrupt();
		clientMario.interrupt();
		
		//Return to main thread execution
		clientMaria.join();
		clientJuan.join();
		clientCeci.join();
		clientMario.join();
		
		System.out.printf("\nBroker has ended his working day\n");
	}

}
