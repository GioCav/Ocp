package giocavi.ocp.comparator;

import giocavi.ocp.collections.Duck;

import java.util.Comparator;

/**
 * Created by Giovanni on 01/10/2016.
 */
public class byWeight implements Comparator<Duck> {
    @Override
    public int compare(Duck o1, Duck o2) {
        return o1.getWeight() - o2.getWeight();
    }
}
