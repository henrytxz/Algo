package mockinterviews;

import org.junit.Assert;
import org.junit.Test;
import utility.SimplePair;
import utility.Triplet;

public class SumToXTest {

    @Test
    public void testFindPair1() throws Exception {
        int[] a = new int[]{1,2,3};
        SumToX sumToX = new SumToX(a);
        SimplePair<Integer> p = sumToX.findPair(5);
        Assert.assertEquals(1, p.getLeft().intValue());
        Assert.assertEquals(2, p.getRight().intValue());
    }

    @Test
    public void testFindPair2() throws Exception {
        int[] a = new int[]{1,2,3};
        SumToX sumToX = new SumToX(a);
        SimplePair<Integer> p = sumToX.findPair(9);
        Assert.assertNull(p);
    }

    @Test
    public void testFindPair3() throws Exception {
        int[] a = new int[]{2};
        SumToX sumToX = new SumToX(a);
        SimplePair<Integer> p = sumToX.findPair(4);
        Assert.assertNull(p);
    }

    @Test
    public void testFindTriplet1() throws Exception {
        int[] a = new int[]{1,2,3};
        SumToX sumToX = new SumToX(a);
        Triplet<Integer> p = sumToX.findTriplet(6);
        Assert.assertTrue(p.contains(0));
        Assert.assertTrue(p.contains(1));
        Assert.assertTrue(p.contains(2));
    }

    @Test
    public void testFindTriplet2() throws Exception {
        int[] a = new int[]{1,2,3};
        SumToX sumToX = new SumToX(a);
        Triplet<Integer> p = sumToX.findTriplet(8);
        Assert.assertNull(p);
    }

    @Test
    public void testFindTriplet3() throws Exception {
        int[] a = new int[]{2};
        SumToX sumToX = new SumToX(a);
        Triplet<Integer> p = sumToX.findTriplet(6);
        Assert.assertNull(p);
    }
}
