package leetCode;

import java.util.Comparator;

/**
 * Created by henry on 10/24/2014.
 */
public class KeyAndOrder implements Comparable {

//    static public final Comparator<KeyAndOrder> BY_ORDER = new ByOrder();

    int key;
    int order;
    public KeyAndOrder(int key, int order) {
        this.key = key;
        this.order = order;
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj) return true;
        if (obj instanceof KeyAndOrder) {
            KeyAndOrder that = (KeyAndOrder) obj;
            return key==that.key&&order==that.order;
        }
        return false;
    }

    @Override
    public String toString() {
        return "["+key+":"+order+"]";
    }

    @Override
    public int compareTo(Object o) {
        if (this==o) return 0;
        KeyAndOrder that = (KeyAndOrder) o;
        if (order < that.order) return -1;
        if (order== that.order) return  0;
        return 1;
    }

    private static class ByOrder implements Comparator<KeyAndOrder>
    {
        @Override
        public int compare(KeyAndOrder ko1, KeyAndOrder ko2) {
            if (ko1.order < ko2.order) return -1;
            if (ko1.order== ko2.order) return  0;
            return 1;
        }
    }
}
