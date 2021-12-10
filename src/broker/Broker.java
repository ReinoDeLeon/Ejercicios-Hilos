package broker;

public class Broker {
	
	private int maxSharesToSell;
	
	public Broker(int _maxSharesToSell) {
		maxSharesToSell = _maxSharesToSell;
	}
	
	public synchronized boolean buy(int _sharesToBuy) {

		System.out.printf("There are %d shares avaliable", maxSharesToSell);
		if (_sharesToBuy < maxSharesToSell) {
			maxSharesToSell-= _sharesToBuy;
			notify();
			System.out.printf("There are %d shares remaining", maxSharesToSell);
			return true;
		}
		else {
			notify();
			return false;
		}
	}
	
	public synchronized void waitUntilNoSharesAvaliable() {
		if (maxSharesToSell > 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
