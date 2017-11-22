
public class MyRunnable implements Runnable{
	MyBarrier barrier = new MyBarrier(4);
	MyThread thread;
	public MyRunnable(MyThread thread) {
		this.thread = thread;
	}
	@Override
	public void run() {
		System.out.println("Started");
		 try {
			barrier.sync();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
