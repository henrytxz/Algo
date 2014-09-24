package sedgy.sort.quicksort;

import edu.princeton.cs.introcs.StdRandom;

/**
 * Created by henry on 7/19/2014.
 * p9 of slide_23Quicksort.pdf by Sedgy
 */

public class Quick {
//    static Logger logger = LoggerFactory.getLogger(Quick.class);  todo
//    java.util.logging.Logger logger =
    public static void sort(Comparable[] a) {
        if (a==null) return;
        StdRandom.shuffle(a);
        sort(a, 0, a.length-1);
    }

    protected static void sort(Comparable[] a, int lo, int hi) {
        if (lo>=hi) return;
        int i = partition(a, lo, hi);
        sort(a, lo, i);
        sort(a, i+1, hi);
    }

    protected static int partition(Comparable[] a, int lo, int hi) {
        int i=lo;
        int j=hi+1;
        while (true) {
            while (less(a[++i], a[lo])) {
                if (i==hi) break;
            }
            while (more(a[--j], a[lo])) {
                if (j==lo) break;
            }
//            System.out.println("i:"+i+", j:"+j);
            if (i>=j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    protected static void exch(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    protected static boolean more(Comparable a, Comparable b) {
        return (a.compareTo(b)>0);
    }

    protected static boolean less(Comparable a, Comparable b) {
        return (a.compareTo(b)<0);
    }
}
