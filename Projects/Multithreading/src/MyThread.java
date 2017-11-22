import java.util.concurrent.CyclicBarrier;


public class MyThread extends Thread {
	
	MyRunnable run;
	public MyThread(MyRunnable run) {
		this.run = run;
	}
}
