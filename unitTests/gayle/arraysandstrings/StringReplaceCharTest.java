package gayle.arraysandstrings;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class StringReplaceCharTest {

    @Test
    public void testReplace() throws Exception {
//        char[] a = new char[12];
        char[] a_ = new char[]{'s',' ','t','r','i',' ','n','g'};
        char[] a = Arrays.copyOf(a_,12);
//        for (char c : a_) {
//
//        }
        String s = new String(a);
        String result = StringReplaceChar.replace(s, a_.length);
        Assert.assertEquals("s%20tri%20ng",result);
    }
}