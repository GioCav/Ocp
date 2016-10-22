package giocavi.ocp.collections;

import java.util.*;

/**
 * Created by Giovanni on 01/10/2016.
 */
public class QueueExample {

    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        System.out.println(deque.offer(1));
        System.out.println(deque.add(2));
        deque.push(3);
        deque.remove(1);
        deque.forEach(System.out::println);
        ((List<Integer>) deque).replaceAll(x -> x*2);
        deque.stream().map(x -> x + " ").forEach(System.out::print);
        System.out.println();

    }
}
