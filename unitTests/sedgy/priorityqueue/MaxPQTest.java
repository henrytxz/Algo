package sedgy.priorityqueue;

import org.junit.Assert;
import org.junit.Test;

public class MaxPQTest extends MaxPQ {

    /*
        java.lang.Exception: Method test_swim() should not be static
     */
    @Test
    public void test_swim() {
        String[] a = {null,"S","P","R","N","T","O","A","E","I","H","G"};
        MaxPQ<String> pq = new MaxPQ<String>(a);
        Assert.assertEquals("S", pq.max());

        pq.swim(5);
        Assert.assertEquals("T", pq.max());
    }

//    @Test
//    public void test_less() {
//        String[] a = {"A","B"};
//        MaxPQ<String> pq = new MaxPQ<String>(a);
//        Assert.assertTrue(a_less_than_b(0,1));
//    }

}