package coreJava;

import org.junit.Test;

/**
 * Created by henry on 9/7/2014.
 */
public class ForEach {
    @Test
    public void test() {
        int[] a = {1,2,3};
        for (int i : a) {
            i+=1;   //doesn't work
        }
        for (int j : a) {
            System.out.println(j);
        }
        System.out.println("============");

        for (int i=0; i<a.length; i++) {
            a[i]+=1;
        }
        for (int j : a) {
            System.out.println(j);
        }
    }
}
