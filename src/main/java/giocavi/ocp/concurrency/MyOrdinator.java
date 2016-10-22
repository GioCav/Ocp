package giocavi.ocp.concurrency;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

/**
 * Created by Giovanni on 20/10/2016.
 */
class myArraySort<T extends Comparable<T>> extends RecursiveAction {
    private T[] array;
    private int begin;
    private int end;

    public myArraySort(T[] array, int begin, int end) {
        this.array = array;
        this.begin = begin;
        this.end = end;
    }

    private void swap(int i, int j) {
        synchronized (array) {
            T temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    private void order(int i, int j, int k) {
        Object[] aux = new Object[k-i];
        int w = j;
        int s = i;
        for(int n = 0; n < aux.length; n++) {
            if (i>=j || (w < k && array[w].compareTo(array[i])<0)) aux[n]=array[w++];
            else aux[n]=array[i++];
        }
        for(int n = 0; n< aux.length; n++) {
            array[s+n]= (T) aux[n];
        }
        /*synchronized (array) {
            System.out.print(s + " " + j + " " + k + " ");
            Arrays.asList(array).stream().map(x -> " " + x).forEach(System.out::print);
            System.out.println();
        }*/
    }

    @Override
    protected void compute() {
        if(array.length < 1) return;
        if(end-begin > 1) {
            int mid = (begin + end)/2;
            invokeAll(new myArraySort<T>(array, begin, mid), new myArraySort<T>(array, mid, end));
            order(begin, mid, end);
        }
    }
}
public class MyOrdinator {
    public static void main(String[] args) {
        System.out.println("Start:");
        Integer[] ar = new Integer[] {3,2,1,4,6,8,9,5};
        Arrays.asList(ar).forEach(System.out::print);
        System.out.println();
        ForkJoinTask<?> task = new myArraySort<Integer>(ar, 0, ar.length);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);
        Arrays.asList(ar).stream().map(x -> " " + x).forEach(System.out::print);
        System.out.println();
    }
}
