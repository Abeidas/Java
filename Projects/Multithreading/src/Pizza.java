public class Pizza extends Thread implements Comparable<Thread> {
	public Pizza(Runnable runnable) {
		this.runnable = runnable;
	}

	Runnable runnable = new Runnable() {

		@Override
		public void run() {
			System.out.println("Pizza is gonna take 5 minutes...");
			start();
		}

	};

	@Override
	public int compareTo(Thread o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
