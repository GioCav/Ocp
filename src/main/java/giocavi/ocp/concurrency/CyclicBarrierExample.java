package giocavi.ocp.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Giovanni on 09/10/2016.
 */
class MyRun implements Runnable {
    private CyclicBarrier cyclicBarrier;
    private int order;

    public MyRun(CyclicBarrier c, int order) {
        cyclicBarrier = c;
        this.order = order;
    }
    @Override
    public void run() {
        try {
            System.out.println("Order : " + order + " Barrier:"+ " " + cyclicBarrier.getNumberWaiting()+ " " + cyclicBarrier.await() + " " + cyclicBarrier.getNumberWaiting());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
public class CyclicBarrierExample {
    public static void main(String[] args) {
        CyclicBarrier c1 = new CyclicBarrier(4, () -> System.out.println("One cycle"));
        ExecutorService service = Executors.newFixedThreadPool(4);
        for(int i = 0 ; i < 16; i++) {
            service.execute(new MyRun(c1, i));
        }
        service.shutdown();
    }
}
