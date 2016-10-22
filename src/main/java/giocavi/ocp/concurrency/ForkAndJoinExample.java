package giocavi.ocp.concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

/**
 * Created by Giovanni on 09/10/2016.
 */
class MyRA extends RecursiveAction {
    private int[] ar;
    private int i;
    private int j;

    public MyRA(int[] ar, int start, int end) {
        this.i = start;
        this.ar = ar;
        this.j = end;
    }
    @Override
    protected void compute() {
        if (j-i <= 0) {
            System.out.println(i);
        } else {
            invokeAll(new MyRA(ar, i, (i+j)/2), new MyRA(ar, (i+j)/2 + 1, j));
            System.out.println("This is the fork " + i + " " + j);
        }
    }
}
public class ForkAndJoinExample {
    public static void main(String[] args) {
        int[] x = new int[10];
        ForkJoinTask<?> task = new MyRA(x, 0, x.length);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);
    }
}
