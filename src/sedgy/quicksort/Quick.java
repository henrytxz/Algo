package sedgy.quicksort;

import edu.princeton.cs.introcs.StdRandom;

/**
 * Created by henry on 7/19/2014.
 * p9 of slide_23Quicksort.pdf by Sedgy
 */

public class Quick {
//    static Logger logger = LoggerFactory.getLogger(Quick.class);
//    java.util.logging.Logger logger =
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length-1);
    }

    protected static void sort(Comparable[] a, int lo, int hi) {
        if (lo>=hi) {
//            logger.info("lo:"+Integer.toString(lo)+", hi:"+Integer.toString(hi));
            return;
        }
        int i = partition(a, lo, hi);
//        System.out.println("post partition");
//        printArray(a);
        sort(a, lo, i - 1);
        sort(a, i + 1, hi);
    }

    protected static int partition(Comparable[] a, int lo, int hi) {
//        System.out.println("in partition");
//        printArray(a);
//        System.out.println("lo:"+Integer.toString(lo)+", hi:"+Integer.toString(hi));
        assert hi <= a.length-1;
        Comparable pivot = a[lo];
        int i = lo+1;
        int j = hi;
        while (true) {
            while (less(a[i], pivot)) {
                if (i==hi) break;
                i++;
            }
            while (more(a[j],pivot)) {
                if (j==lo) break;
                j--;
            }

            if (i>=j) {
                exch(a, lo, j);
                return j;
            } else {
                exch(a, i, j);
            }
        }
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
