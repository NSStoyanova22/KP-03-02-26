import java.util.concurrent.BlockingQueue;

class Waiter implements Runnable {
    private String name;
    private BlockingQueue<Order> orderQueue;

    public Waiter(String name, BlockingQueue<Order> orderQueue) {
        this.name = name;
        this.orderQueue = orderQueue;
    }

    public void run() {
        try {
            while(true) {
                Order order = (Order)this.orderQueue.take();
                String var10001 = this.name;
                System.out.println(var10001 + " is serving: " + order.getFood() + ", " + order.getQuantity() + " times");
                Thread.sleep(200L);
                var10001 = this.name;
                System.out.println(var10001 + " delivered: " + order.getFood() + ", " + order.getQuantity() + " times");
            }
        } catch (InterruptedException var2) {
            System.out.println(this.name + " stopped.");
        }
    }
}
