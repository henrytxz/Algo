package coreJava;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by henry on 9/18/2014.
 */
public class StringMethods {
    @Test
    public void test() {
        String s = "hello";
        Assert.assertEquals("", s.substring(5));

        String[] strArray = new String[] {"John", "Mary", "Bob"};
        System.out.println(Arrays.toString(strArray));
    }
}
