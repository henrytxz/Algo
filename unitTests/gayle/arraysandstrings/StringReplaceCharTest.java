package gayle.arraysandstrings;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class StringReplaceCharTest {

    /*
        test case: s tri ng$$$$ (I'm using $ instead of null)
        output:    s%20tri%20ng
     */
    @Test
    public void testReplace() throws Exception {
        char[] a_ = new char[]{'s',' ','t','r','i',' ','n','g'};
        char[] a = Arrays.copyOf(a_,12);
        String s = new String(a);
        String result = StringReplaceChar.replace(s, a_.length);
        Assert.assertEquals("s%20tri%20ng",result);
    }
}