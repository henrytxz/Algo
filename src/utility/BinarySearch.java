package utility;

/**
 * Created by henry on 8/10/2014.
 */
public class BinarySearch {

    public static int search(int[] a, int key) {
        return bs(a, key, 0, a.length-1);
    }

    private static int bs(int[] a, int key, int lo, int hi) {
        if (lo==hi && a[lo]!=key) return -1;
        if (lo>hi) return -1;

        int mid = (lo+hi)/2;

        if (a[mid]==key) return mid;
        else if (key < a[mid]) return bs(a, key, lo, mid-1);
        else return bs(a, key, mid+1, hi);
    }

}
