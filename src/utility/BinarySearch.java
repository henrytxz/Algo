package utility;

/**
 * Created by henry on 8/10/2014.
 */
public class BinarySearch {

    public static int search(int[] a, int key) {
        return search(a, key, 0, a.length-1);
    }

    private static int search(int[] a, int key, int start, int end) {
        if (start==end) {
            if (key!=a[start]) return -1;
        }

        int mid = (start+end)/2;
        if (start+1==end) {          //this is because when (start,end) = (3,4), mid will never be 4 (Java integer division truncates) => to read another Java implementation of Binary Search
            return Math.max(search(a,key,start,start), search(a,key,end,end));
        }
        if (key==a[mid]) return mid;
        else if (key<a[mid]) return search(a, key, start, mid);
        else {
            return search(a, key, mid, end);
        }
    }
}
