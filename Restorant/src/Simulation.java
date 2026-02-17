import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Simulation {
    public static void main(String[] args) {
        BlockingQueue<Order> orderQueue = new ArrayBlockingQueue(10);
        Thread kitchenThread = new Thread(new Kitchen(orderQueue));
        kitchenThread.start();
        Thread waiter1 = new Thread(new Waiter("Waiter 1", orderQueue));
        Thread waiter2 = new Thread(new Waiter("Waiter 2", orderQueue));
        waiter1.start();
        waiter2.start();

        try {
            orderQueue.put(new Order("Pizza", 2));
            orderQueue.put(new Order("Pasta", 1));
            orderQueue.put(new Order("Salad", 3));
            orderQueue.put(new Order("Soup", 2));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
