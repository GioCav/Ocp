package giocavi.ocp.collections;

/**
 * Created by Giovanni on 01/10/2016.
 */
public class Duck implements Comparable<Duck> {
    private String name;
    private int weight;
    public Duck(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Duck o) {
        return name.compareTo(o.name);
    }
}
