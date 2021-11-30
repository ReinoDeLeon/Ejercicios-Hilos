package filosofos;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		DiningPhilosopher diningPhilosopher = new DiningPhilosopher();
		List<Fork> forks = new ArrayList<Fork>();
		for (int i = 0; i < 5; i++) {
			forks.add(new Fork());
		}
		List<Philosopher> philosopher = new ArrayList<Philosopher>();
		for (int i = 0; i < 5; i++) {
			// We get the right fork as a module of 5 so when i=4 we get 4+1%5 = 0
			philosopher.add(new Philosopher(i, diningPhilosopher, forks.get(i), forks.get((i + 1) % 5)));
			// We start them on the same for loop so it is a bit more efficient
			philosopher.get(i).start();
		}

	}

}
