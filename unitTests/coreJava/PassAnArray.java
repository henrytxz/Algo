package coreJava;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by henry on 9/7/2014.
 */
public class PassAnArray {
    @Test
    public void test() {
        int[] a = {1,2,3};
        int[] b = foo(a, 0);
        System.out.println(Arrays.toString(a));

        int[] c = a.clone();
        b = foo(c, 1);
        System.out.println(Arrays.toString(c));
        System.out.println(Arrays.toString(a));
    }

    private int[] foo(int[] a, int i) {
        a[i] = 0;
        return a;
    }
}
