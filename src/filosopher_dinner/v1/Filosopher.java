package filosopher_dinner.v1;

public class Filosopher implements Runnable {

	private Fork left, right;
	private String name;
	private int counter, fixTime;

	public Filosopher(Fork l, Fork r, int time) {
		left = l;
		right = r;
		fixTime = time;
		counter = 0;
	}
	
	public Filosopher(Fork left, Fork right) {
		this(left, right, -1);
	}
	
	private void think() throws InterruptedException {
		int time = fixTime > 0 ? fixTime : (int) (Math.random() * 10000);
		Thread.sleep(time);
		System.out.println(name + " [" + counter + "] pensando (" + time + ")");
	}
	
	public void eat() throws InterruptedException {
		int time = fixTime > 0 ? fixTime : (int) (Math.random() * 10000);
		left.use();
		right.use();
		counter++;
		Thread.sleep(time);
		System.out.println(name + " [" + counter + "] comendo (" + time + ")");
		if (counter % 5 == 0)
			System.out.println();
		right.discard();
		left.discard();
	}

	@Override
	public void run() {
		this.name = Thread.currentThread().getName();
		while (true) {
			try {
				think();
				eat();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}

}
