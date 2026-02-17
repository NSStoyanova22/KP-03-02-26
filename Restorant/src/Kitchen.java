import java.io.PrintStream;
import java.util.concurrent.BlockingQueue;

public class Kitchen implements Runnable {
    private BlockingQueue<Order> orderQueueQ;

    public Kitchen(BlockingQueue<Order> orderQueueQ) {
        this.orderQueueQ = orderQueueQ;
    }

    public void run() {
        Order order = null;

        try {
            while(true) {
                order = (Order)this.orderQueueQ.take();
                PrintStream var10000 = System.out;
                String var10001 = order.getFood();
                var10000.println("Order " + var10001 + ", " + order.getQuantity() + " times is being prepared");
                Thread.sleep((long)(200 * order.getQuantity()));
                var10000 = System.out;
                var10001 = order.getFood();
                var10000.println("Kitchen finished order " + var10001 + ", " + order.getQuantity() + " times.");
            }
        } catch (InterruptedException var3) {
            System.out.println("The kitchen stopped");
        }
    }
}
