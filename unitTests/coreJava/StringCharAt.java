package coreJava;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by henry on 9/25/2014.
 */
public class StringCharAt {
    @Test
    public void test() {
        String s = "hello";
        char c = s.charAt(0);
        Assert.assertEquals('h', c);

        int val = c;
        Assert.assertEquals(104, val);
    }
}
