
public class Seller extends Thread implements Comparable<Thread> {

	Runnable runnable = new Runnable() {

		@Override
		public void run() {
			System.out.println("Pizza is gonna take 5 minutes...");
			start();
		}

	};
	@Override
	public int compareTo(Thread o) {
		return 0;
	}

}
