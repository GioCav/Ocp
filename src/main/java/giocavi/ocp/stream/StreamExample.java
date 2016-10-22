package giocavi.ocp.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Giovanni on 05/10/2016.
 */
public class StreamExample {
    public static void main(String[] args) {
        Stream<String> s = Stream.of("bau", "miao", "mio");
        String res = s.min((s1, s2) -> s1.length() - s2.length()).get();
        System.out.println(res);
        Stream<Integer> integerStream = Stream.iterate(1, n -> n + 2);
        integerStream.limit(10).parallel().forEach(System.out::println);
        Stream<Integer> cost = Stream.iterate(0, n -> n+1);
        List<Integer> clist = cost.parallel().limit(10).collect(ArrayList<Integer>::new, List::add, List::addAll);
        System.out.println(Collectors.toList().characteristics());
        System.out.println(Collectors.toConcurrentMap(x -> x, x -> x).characteristics());
        //Stream.generate(ArrayList<Integer>::new).limit(5).sorted().forEach(System.out::println);
        //System.out.println(integerStream.findFirst().get());
        //System.out.println(integerStream.findFirst().get());
    }
}
