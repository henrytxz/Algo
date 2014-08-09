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

    @Test
    public void test_sink() {
        String[] a = {null,"T","H","R","P","S","O","A","E","I","N","G"};
        MaxPQ<String> pq = new MaxPQ<String>(a);
        Assert.assertArrayEquals(a, pq.getPq());

        pq.sink(2);

        //T S R P N O A E I H G
        String[] expected = {null,"T","S","R","P","N","O","A","E","I","H","G"};
        Assert.assertArrayEquals(expected, pq.getPq());
    }

}