package giocavi.ocp.collections;

import java.util.*;

/**
 * Created by Giovanni on 01/10/2016.
 */
public class SetExample {
    public static void main(String[] args) {
        Set<Duck> duckSet = new TreeSet<>();
        Set<Duck> UnDuckSet = new HashSet<>();
        List<String> list = Arrays.asList("pippo", "qui", "quo", "axbo");
        list.stream().map(Duck::new).forEach(duckSet::add);
        list.stream().map(Duck::new).forEach(UnDuckSet::add);
        duckSet.forEach(x -> System.out.print(x + " "));
        System.out.println();
        UnDuckSet.forEach(x -> System.out.print(x + " "));
        System.out.println();
        // Use of comparator
        //Collections.sort(list, (s1,s2) -> s1.charAt(1) - s2.charAt(1));
        Collections.sort(list, Comparator.comparing(s -> s.charAt(1)));
        System.out.println(list);
        System.out.println((Duck) null instanceof Object);
    }
}
