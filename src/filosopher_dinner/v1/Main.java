package filosopher_dinner.v1;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		int nFilosopher = 3;
		ArrayList<Fork> forks = new ArrayList<Fork>();
		for (int i = 0; i < nFilosopher; i++)
			forks.add(new Fork(i));

		int n = forks.size();
		for (int i = 0; i < n; i++) {
			Fork left = forks.get(i);
			Fork right = forks.get((i + 1) % n);
			Filosopher filosopher = new Filosopher(left, right, 25);
			Thread thread = new Thread(filosopher);
			thread.start();
		}
	}
}
