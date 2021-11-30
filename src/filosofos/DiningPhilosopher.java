package filosofos;

public class DiningPhilosopher {

	public synchronized void grabForks(Fork leftFork, Fork rightFork) throws InterruptedException {
		//If both forks aren't available we wait for them to be
		while (!leftFork.avaliable || !rightFork.avaliable) {
			wait();
		}
		leftFork.avaliable = false;
		rightFork.avaliable = false;
		notifyAll();

	}

	public synchronized void releaseForks(Fork leftFork, Fork rightFork) {
		leftFork.avaliable = true;
		rightFork.avaliable= true;
		notifyAll();
	}

}
