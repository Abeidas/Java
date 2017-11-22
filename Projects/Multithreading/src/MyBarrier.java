

public class MyBarrier {
	int arrived = 0;
	final int threads;
	public MyBarrier(int threads) {
		this.threads = threads;
	}
	public synchronized void sync() throws InterruptedException {
		System.out.println(this.getClass().getName());
		arrived++;
		if (arrived == threads) {
			arrived = 0;
			notifyAll();
			System.out.println(this.getClass().getName());
			
		} else if (threads > arrived) {
			while (arrived > 0) {
			    

				this.wait();

			    
			}
		}
	}
}