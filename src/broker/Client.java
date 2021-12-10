package broker;

public class Client extends Thread {

	private String name;
	private Broker broker;
	private int numberOfSharesBought;
	
	public Client(String _name, Broker _broker) {
		name = _name;
		broker = _broker;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep((long) (Math.random()*2000));
				int sharesToBuy = (int) (Math.random()*4)+1;
				System.out.printf("Client %s is trying to buy %d shares from broker\n", name, sharesToBuy);
				if (broker.buy(sharesToBuy)){
					numberOfSharesBought+=sharesToBuy;
					System.out.printf("Client %s has bought %d shares\n\n", name, sharesToBuy);
				}
				else {
					System.out.printf("Client %s was unable to buy %d shares\n\n", name, sharesToBuy);
				}
				
			} catch (InterruptedException e) {
				System.out.printf("Client %s has bought %d shares in total\n", name, numberOfSharesBought);
				break;
			}
		}
	}
}
