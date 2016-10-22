package giocavi.ocp.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Giovanni on 09/10/2016.
 */
public class CopyOnWriteExample {
    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();
        List<Integer> libd = list;
        list.add(10);
        list.add(20);
        list.add(30);
        CopyOnWriteArrayList<Integer> arl = (CopyOnWriteArrayList<Integer>) libd;
        Integer[] arr = new Integer[3];
        arl.toArray(arr);
        for(Integer n : arr)
        System.out.println(n.intValue());
    }
}
