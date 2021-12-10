package broker;

public class Broker {
	
	private final int maxSharesToSell;
	private int availableShares;
	
	public Broker(int _maxSharesToSell) {
		maxSharesToSell = _maxSharesToSell;
		availableShares = maxSharesToSell;
	}
	
	public synchronized boolean buy(int _sharesToBuy) {
		System.out.printf("There are %d shares avaliable\n", availableShares);
		//if sharesToBuy < maxSharesToSell then we update the number of available shares and notify all the threads that we are over with buying process
		if (_sharesToBuy <= availableShares) {
			availableShares-= _sharesToBuy;
			System.out.printf("There are %d shares remaining\n", availableShares);
			notifyAll();
			return true;
		}
		else {
			notifyAll();
			return false;
		}
	}
	
	public synchronized void waitUntilNoSharesAvaliable() throws InterruptedException {
		while (availableShares > 0) {
			wait();
		}
	}
}
