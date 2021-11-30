package filosofos;

public class Philosopher extends Thread {

	private final DiningPhilosopher diningPhilosopher;
	private final Fork leftFork;
	private final Fork rightFork;

	public Philosopher(int _id, DiningPhilosopher _dininDiningPhilosopher, Fork _leftFork, Fork _rightFork) {
		super(String.format("Philosopher-%d", _id));
		diningPhilosopher = _dininDiningPhilosopher;
		leftFork = _leftFork;
		rightFork = _rightFork;

	}

	private void randomSleep() throws InterruptedException {
		Thread.sleep((int) (Math.random() * 2000) + 1000);
	}

	@Override
	public void run() {
		for (int dinner = 0; dinner < 3; dinner++) {
			try {
				// Meditate
				System.out.printf("%s meditating\n", getName());
				randomSleep();

				// Grab forks
				System.out.printf("%s waiting for fork availability\n", getName());
				diningPhilosopher.grabForks(leftFork, rightFork);

				// Eat
				System.out.printf("%s dining\n", getName());
				randomSleep();

				// Release forks
				System.out.printf("%s releasing used forks\n", getName());
				diningPhilosopher.releaseForks(leftFork, rightFork);

			} catch (InterruptedException i) {
				break;
			}

		}

	}

}
