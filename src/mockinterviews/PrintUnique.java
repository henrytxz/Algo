package mockinterviews;

import java.util.Arrays;

/**
 * Created by henry on 9/2/2014.
 */
public class PrintUnique {
    public static void printUnique(int[] a) {
        Arrays.sort(a);
        int count = 0;
        for (int i=0; i<a.length; i++) {
            if (i>0 && a[i]!=a[i-1])    //new element found
            {
                if (count==1) System.out.println(a[i-1]);   //last element is unique
                count = 0;
            }
            count++;    //increment count at the end of the for loop
        }
        if (count==1) System.out.println(a[a.length-1]);
    }
}
