package utility;

/**
 * Created by henry on 8/10/2014.
 */
public class BinarySearch {

    public static int search(int[] a, int key) {
        int lo = 0;
        int hi = a.length-1;

        while (lo<=hi) {
            int mid = (lo+hi)/2;
            if (a[mid]==key) {
                return mid;
            } else if (key<a[mid]) {
                hi = mid-1;
            } else {
                lo = mid+1;
            }
        }
        return -1;
    }
}
