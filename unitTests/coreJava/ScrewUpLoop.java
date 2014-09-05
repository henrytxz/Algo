package coreJava;

import org.junit.Test;

/**
 * Created by henry on 9/5/2014.
 */
public class ScrewUpLoop {

    @Test
    public void test() {
        int[] a = {1,3,5};
        int[] b = {2,4,6};
        System.out.println("as you can tell from the output, changing the collection midway doesn't work");
        for (int i:a) {
            System.out.println(i);
            a = b;
        }
        System.out.println("now it changes");
        for (int i:a) {
            System.out.println(i);
        }
    }

}
