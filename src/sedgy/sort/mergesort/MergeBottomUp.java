package sedgy.sort.mergesort;

/**
 * Created by henry on 8/16/2014.
 */
public class MergeBottomUp extends Merge {
    public static void sort(Comparable[] a) {
        int N = a.length;
        Comparable[] b = new Comparable[a.length];
        for (int sz=1; sz<N; sz=sz*2) {
            for (int lo=0; lo+sz<N; lo+=sz*2) {
                merge(a, b, lo, lo+sz-1, Math.min(lo+2*sz-1, N-1));
            }
        }
    }
}
