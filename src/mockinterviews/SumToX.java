package mockinterviews;

import utility.SimplePair;
import utility.Triplet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by henry on 9/15/2014.
 */
public class SumToX {
    private int[] a;
    private Map<Integer, Integer> m;

    public SumToX(int [] a) {
        this.a = a;
        m = new HashMap<Integer, Integer>();
        for (int i=0; i<a.length; i++) {
            m.put(a[i], i);
        }
    }

    private SimplePair<Integer> findPair(int x, int k) {
        if (a==null || a.length<2) return null;

        for (int i=0; i<a.length; i++) {
            if (i==k) continue;
            int y = x-a[i];
            if (m.containsKey(y) && m.get(y)!=i && m.get(y)!=k) {
                return new SimplePair<Integer>(i, m.get(y));
            }
        }
        return null;
    }

    //for eg, a={1,2,3} and x = 6
    public Triplet<Integer> findTriplet(int x) {
	    for (int i=0; i<a.length; i++) {
            SimplePair<Integer> p = findPair(x-a[i], i);
            if (p!=null) return new Triplet<Integer>(i, p.getLeft(), p.getRight());
        }
        return null;
    }

    public SimplePair<Integer> findPair(int x) {
        if (a==null || a.length<2) return null;

        for (int i=0; i<a.length; i++) {
            int y = x-a[i];
            if (m.containsKey(y) && m.get(y)!=i) {
                return new SimplePair<Integer>(i, m.get(y));
            }
        }
        return null;
    }
}
