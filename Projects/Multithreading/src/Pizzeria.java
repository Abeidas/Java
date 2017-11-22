import java.util.Queue;

public class Pizzeria {
	Queue<Pizza> queue;
	Queue<Seller> seller;

	public Pizzeria(Queue<Pizza> queue, Queue<Seller> seller) {
		this.queue = queue;
		this.seller = seller;
	//backe, if the oven is full, then wait for a pizza to finish,
	//then add a pizza to the oven,
	}
	synchronized void Backe(Pizza pizza) throws InterruptedException {
		while (queue.size() == 2) {
			System.out.println("oven is full!");
			queue.peek().join();
			queue.poll();
		}
		queue.add(pizza);
		System.out.println("Pizza is being baked..");
		notify();
	}

	synchronized Thread sell() throws InterruptedException {
		
		if (queue.isEmpty()) {
			System.out.println("queue is empty");
			try {
				queue.peek().join();
				System.out.println("Waiting for a seller to finish..");
				

			} catch (NullPointerException e) {
				System.out.println("No Pizza are in the oven");
			}

		} if(seller.isEmpty()) {
			System.out.println("sellers are busy");
			seller.peek().join();
			seller.add(new Seller());
			System.out.println("Pizza is removed from oven");
			System.out.println("Pizza is served!");
		} if(!seller.isEmpty() && !queue.isEmpty()) { 
			System.out.println("Pizza succesfully sold");
		}
		seller.poll();
		return queue.poll();
	}
}
