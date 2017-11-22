import java.util.concurrent.CyclicBarrier;

public class MyRunnable implements Runnable {
	int height;
	int width;
	int i;
	int j;
	public void fill(int[][] numbers) {
		for(int i = 0; i < numbers.length; i++) {
			for(int j = 0; j < numbers[i].length; j++) {
				numbers[i][j] = i*2*j;
			}
		}
	}
	CyclicBarrier barrier = new CyclicBarrier(4);
	public MyRunnable(int height, int width, int i, int j) {
		this.height = height;
		this.width = width;
		this.i = i;
		this.j = j;
	}

	public void run() {
		
		if( j > height - 4) {
			j = 0;
			i++;
		} else {
			j += 4;
		}
		
		if (width != i && j != height) {
			new Thread(this).start();
		}
		
		
		
	


	}
}
