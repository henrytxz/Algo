package leetCode;

import java.util.Comparator;

/**
 * Created by henry on 10/24/2014.
 */
public class KeyAndOrder {

    static public final Comparator<KeyAndOrder> BY_ORDER = new ByOrder();

    int key;
    int order;
    public KeyAndOrder(int key, int order) {
        this.key = key;
        this.order = order;
    }

    @Override
    public boolean equals(Object obj) {
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
