package coreJava;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by henry on 9/5/2014.
 */
public class ScrewUpLoop {

    @Test
    public void test1() {
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

    @Test
    public void test2() {
        List<String> l = new LinkedList<String>();
        System.out.println("let's see what happens when looping through an empty List");
        for (String s : l) {
            System.out.println(s);
        }
    }

    @Test (expected=NullPointerException.class)
    public void test_loopingThroughNullThrows() {
        System.out.println("let's see what happens when looping through null");
        List<String> l = null;
        for (String s : l) {
            System.out.println(s);
        }
    }
}
