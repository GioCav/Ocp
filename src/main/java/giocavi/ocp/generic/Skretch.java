package giocavi.ocp.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Giovanni on 22/10/2016.
 */
public class Skretch {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        //List<Number> numbers = new ArrayList<Integer>();
        List<? extends Number> widenum = new ArrayList<>();
        //widenum.add(3);
    }
}
