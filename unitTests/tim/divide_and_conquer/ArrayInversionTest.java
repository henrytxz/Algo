package tim.divide_and_conquer;

import junit.framework.Assert;
import org.junit.Test;
import utility.MyArrayUtil;
import utility.Pair;

/**
 * User: henry
 * Date: 8/18/13
 * Time: 11:36 AM
 */

public class ArrayInversionTest {

    @Test
    public void testSmallExample() throws Exception {
//        int[] A = new int[]{5,2};

        Integer[] A = new Integer[]{1,3,5,2,4,6};

        Pair<Integer[], Integer> D_and_total = ArrayInversion.SortAndCount(A, A.length, 0, A.length - 1);
        MyArrayUtil.checkArrayIntegerSorted(D_and_total.getLeft());
    }

    @Test
    public void test_bruteForceCount() throws Exception {
        System.out.println("Integer.MAX_VALUE is " + Integer.MAX_VALUE);

        Integer[] A = new Integer[]{1,3,5,2,4,6};

        int i=0;
        int j=1;
        int l=6;

        Assert.assertEquals(3, ArrayInversion.bruteForceCount(A));
    }

    @Test
    public void test_BigInteger_bruteForceCount() throws Exception {
        Integer[] A = new Integer[]{1,3,5,2,4,6};

        int i=0;
        int j=1;
        int l=6;

        Assert.assertEquals(3, ArrayInversion.BigInteger_bruteForceCount(A).intValue());
    }
}
