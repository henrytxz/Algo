package sedgy.sort.mergesort;

import java.util.Arrays;

/**
 * Created by henry on 9/3/2014.
 */
public class MergeSept3 {
    public static void sort(int[] a)    //todo: try an array of Generics
    {
        int[] aux = Arrays.copyOf(a, a.length);
        ms(a, aux, 0, a.length-1);
    }

    private static void ms(int[] a, int[] aux, int lo, int hi) {
        if (lo>=hi) return;
        int mid = (lo+hi)/2;
        ms(a, aux, lo, mid);
        ms(a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);
    }

    private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        assert isSortedAscendingOrder(a, lo, mid);
        assert isSortedAscendingOrder(a, mid+1, hi);
        int i = lo;
        int j = mid+1;
        int k = i;
        while (true) {
            if (i>mid && j>hi) break;
            else if (i>mid) a[k] = aux[j++];
            else if (j>hi)  a[k] = aux[i++];
            else {
                if (aux[i]<=aux[j]) a[k] = aux[i++];
                else a[k] = aux[j++];
            }
            k++;
        }

        System.arraycopy(a, 0, aux, 0, a.length);
    }

    private static boolean isSortedAscendingOrder(int[] a, int lo, int hi) {
        for (int i=lo; i<hi; i++) {
            if (a[i]>a[i+1])
                return false;
        }
        return true;
    }
}
