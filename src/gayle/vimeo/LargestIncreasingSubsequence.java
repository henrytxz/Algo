package gayle.vimeo;

/**
 * Created by henry on 8/6/2014.
 */
public class LargestIncreasingSubsequence {
    public static int findMax(int[] a) {
        int max = 0;
        int count = 0;
        if (a.length<2) return a.length;
        for (int i=1; i<a.length;) {
            while (a[i]>=a[i-1]) {
                count++;
                i++;
            }
            if (count>max) max=count;
            count=0;
            i++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,-5,-6,-1,0};
        System.out.println(findMax(a));
    }
}
