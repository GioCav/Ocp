package giocavi.ocp.concurrency;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by Giovanni on 09/10/2016.
 */
public class ConcurrentClassesExample {
    public static void main(String[] args) throws InterruptedException {
        Map<String, Integer> map = new ConcurrentHashMap<>();
        map.put("ciao", 10);
        BlockingDeque<Integer> deque = new LinkedBlockingDeque<>(1);
        //The regular method do not throw exceptions;
        deque.offer(20);
        System.out.println("Deque is full");
        // The special methods of a blockingDeque may throw InterruptedException
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(() -> {
            synchronized (deque) {
            }
        });
        //Thread.sleep(7000);
        System.out.println("Continuing my job");
        Boolean isAv = true;
        Future<Boolean> f = service.submit(() -> {
            Boolean av;
        try {
            av = deque.offer(10, 1, TimeUnit.SECONDS);
            System.out.println("Waiting one second ");
        } catch (InterruptedException e) {
            e.printStackTrace();
            av = false;
        }
        return av;
        });
        service.shutdown();
        Thread.sleep(500);
        System.out.println("Removing...");
        deque.poll();
        Thread.sleep(500);
        try {
            System.out.println(deque + " " + f.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
