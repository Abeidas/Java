import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;




public class Main {
	
	static CyclicBarrier barrier = new CyclicBarrier(100);
	static int balance = 0;
	static Runnable run = new Runnable() {

		@Override
		public void run() {
			System.out.println("Started");
			
		 try {
			barrier.await();
			
		} catch (BrokenBarrierException e) {
			
		} catch (InterruptedException e) {
			
		}
		}
	};
	public static void main(String args[]) throws InterruptedException {
		Thread[] thread = new Thread[100];
		for( int i = 0; i < 100; i++) {
			System.out.println("asd");
			thread[i] = new Thread(run);
			thread[i].start();
		}
		
		
	}
}
//	public static void main(String args[]) {
//		System.out.println(Runtime.getRuntime().availableProcessors());
//		Runnable runnable = new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("Pizza is gonna take 5 minutes...");
//			}
//		};
//		Pizza pizza = new Pizza(runnable);
//		
//		pizza  = new Pizza(pizza.runnable);
//		Queue<Pizza> oven = new PriorityQueue<Pizza>();
//		Queue<Seller> seller = new PriorityQueue<Seller>(); 
//		seller.add(new Seller());
//		seller.add(new Seller());
//		seller.add(new Seller());
//		Pizzeria restaurant = new Pizzeria( oven, seller );
//		try {
//			restaurant.Backe(pizza);
//			restaurant.Backe(pizza);
//			restaurant.Backe(pizza);
//			restaurant.sell();
//			restaurant.sell();
//			restaurant.sell();
//			
//			
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//}
