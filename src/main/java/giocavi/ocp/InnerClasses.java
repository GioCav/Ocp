package giocavi.ocp;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

/**
 * Created by Giovanni on 20/10/2016.
 */
public class InnerClasses {
    public static void main(String[] args) throws InterruptedException {
        int i = 3;
        List<Integer> list = new CopyOnWriteArrayList<>();
        list.add(9);
        Runnable run = new Runnable() {
            public void run() {
                try {
                    list.add(8);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(list);
            }
        };
        Runnable run2 = () -> {
            System.out.println(i);
        };
        (new Thread(run)).start();
        Thread.sleep(500);
        list.add(10);
        //run.run();
    }
}
