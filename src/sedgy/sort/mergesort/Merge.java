package sedgy.sort.mergesort;

/**
 * Created by henry on 8/2/2014.
 */
public class Merge {
    public static void sort(Comparable[] a) {
        Comparable[] b = new Comparable[a.length];
        sort(a, b, 0, a.length-1);
    }

    private static void sort(Comparable[] a, Comparable[] b, int lo, int hi) {
        if (lo >= hi) return;
        int mid = (lo+hi)/2;
        sort(a, b, lo, mid);
        sort(a, b, mid+1, hi);
        merge(a, b, lo, mid, hi);
    }

    protected static void merge(Comparable[] a, Comparable[] b, int lo, int mid, int hi) {
//        assert isSorted(a, lo, mid);
//        assert isSorted(a, mid+1, hi);
//        b = Arrays.copyof(a, a.length);     // Java generics
        for (int m=0; m<a.length; m++) {
            b[m] = a[m];
        }
        int i = lo;
        int j = lo;
        int k = mid+1;
        while (j<=mid || k<=hi) {
            if (j>mid) {
                a[i] = b[k++];
            } else if (k>hi) {
                a[i] = b[j++];
            } else if (b[j].compareTo(b[k])<=0) {
                a[i] = b[j++];
            } else {
                a[i] = b[k++];
            }
            i++;
        }
//        assert isSorted(a, lo, hi);
    }
}