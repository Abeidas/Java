
public class Main {
	
	

	public static void main(String args[]) {
		int i = 0;
		int j = 0;
		MyRunnable[] run = new MyRunnable[4];
		for( int k = 0; k < 4; k++) {
			run[i] = new MyRunnable(500, 500, k, j);
		}
		
		Thread[] threads = new Thread[4];
		for (int l = 0; l < 4; l++) {
			
			threads[l] = new Thread(run[l]);
			threads[l].start();
		}System.out.println();
	}

}
