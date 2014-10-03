package gayle.sortingandsearching;

/**
 * Created by henry on 9/30/2014.
 * used by the CircusTower class
 */
public class Htwt implements Comparable {
    private Integer height;
    private Integer weight;

    public Htwt(Integer h, Integer w) {
        height = h;
        weight = w;
    }

    @Override
    public String toString() {
        return "("+height+","+weight+")";
    }

    @Override
    public int compareTo(Object o) {
        Htwt that = (Htwt) o;
        if (this.height.equals(that.height))
            return this.weight.compareTo(that.weight);
        else
            return this.height.compareTo(that.height);
    }

    public boolean isBefore(Htwt other) {
        return height < other.height && weight < other.weight;
    }
}
