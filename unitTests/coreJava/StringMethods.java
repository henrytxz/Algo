package coreJava;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by henry on 9/18/2014.
 */
public class StringMethods {
    @Test
    public void test_subString1() {
        String s = "hello";
        Assert.assertEquals("", s.substring(5));

        String[] strArray = new String[] {"John", "Mary", "Bob"};
        System.out.println(Arrays.toString(strArray));
    }

    @Test
    public void test_subString2() {
        String b = "b";
        Assert.assertEquals("", b.substring(0,0));
        Assert.assertEquals("b", b.substring(0));

        String abb = "abb";
        Assert.assertEquals(abb, abb.substring(0));
    }

    @Test
    public void test_strip() {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(s.replaceAll("\\s", ""));
        System.out.println(s.replaceAll("[^a-zA-Z]", ""));
        System.out.println(s.replaceAll("[^a-zA-Z ]", ""));
    }
}
