package giocavi.ocp.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Giovanni on 01/10/2016.
 */
public class MapExample {
    public static void main(String[] args) {
        Map<Integer, String> hashmap = new HashMap<>();
        Map<Integer, String> treemap = new TreeMap<>();
        hashmap.put(3, "ciao");
        hashmap.put(2, "bau");
        hashmap.put(1, "bau");
        treemap.put(1, "primo");
        treemap.put(3, "secondo");
        treemap.put(2, "terzo");
        hashmap.keySet().forEach(System.out::println);
        treemap.keySet().forEach(System.out::println);
        System.out.println(hashmap.remove(4));
        System.out.println(hashmap.remove(2));
        System.out.println(hashmap.get(1));
    }
}
