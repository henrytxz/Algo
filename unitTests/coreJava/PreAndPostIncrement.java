package coreJava;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by henry on 9/23/2014.
 */
public class PreAndPostIncrement {
    @Test
    public void test0() {
        int a = 1;
        int b = ++a + a++;
        Assert.assertEquals(3, a);
        Assert.assertEquals(4, b);  //4 if compiler evaluates left to right, 3 if right to left
    }

    @Test   //http://stackoverflow.com/questions/2371118/explain-working-of-post-and-pre-increment-operator-in-java
    public void test() {
        int a=5, i;
        i=++a + ++a + a++;
        Assert.assertEquals(20, i);

        a = 5;
        i=a++ + ++a + ++a;
        Assert.assertEquals(20, i);
    }

    @Test
    public void testStack() //slide 13 Sedgewick Stacks and Queues
    {
        String[] s = new String[]{"to","be","or","not","to","be"};
        int N = s.length;
        Assert.assertEquals(6, N);
        Assert.assertEquals("be", s[--N]);
    }
}
