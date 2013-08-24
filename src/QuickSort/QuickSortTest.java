package QuickSort;

import UtilityClasses.MyArrayUtil;
import junit.framework.Assert;
import org.junit.Test;

import static QuickSort.QuickSort.sortAndCountNumberOfSwaps;
import static QuickSort.QuickSort.swap;

/**
 * Created with IntelliJ IDEA.
 * User: henry
 * Date: 8/24/13
 * Time: 1:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class QuickSortTest {
    @Test
    public void testPartition() throws Exception {
        int[] A0 = new int[]{8,7,6};
        Assert.assertEquals(1, sortAndCountNumberOfSwaps(A0));

        int[] A1 = new int[]{5,8,4,7,6};
        Assert.assertEquals(3, sortAndCountNumberOfSwaps(A1));

        int[] A = new int[]{3,8,2,5,1,4,7,6};
        Assert.assertEquals(6, sortAndCountNumberOfSwaps(A));
        MyArrayUtil.checkArrayintSorted(A);
    }

    @Test
    public void testSwap() throws Exception {
        int[] A = new int[]{1,2};
        swap(A,0,1);
        Assert.assertEquals(2, A[0]);
        Assert.assertEquals(1, A[1]);
    }
}
