package tim.quicksort;

import org.junit.Assert;
import org.junit.Test;
import utility.MyArrayUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static tim.quicksort.QuickSort.sortAndCountNumberOfSwaps;
import static tim.quicksort.QuickSort.swap;

/**
 * User: henry
 * Date: 8/24/13
 * Time: 1:53 PM
 */

public class QuickSortTest {
    @Test
    public void testPartition() throws Exception {
        Integer[] A0 = new Integer[]{8,7,6};
        Assert.assertEquals(1, sortAndCountNumberOfSwaps(A0));

        Integer[] A1 = new Integer[]{5,8,4,7,6};
        Assert.assertEquals(3, sortAndCountNumberOfSwaps(A1));

        Integer[] A = new Integer[]{3,8,2,5,1,4,7,6};
        Assert.assertEquals(6, sortAndCountNumberOfSwaps(A));
        MyArrayUtil.checkArrayIntegerSorted(A);
    }

    @Test
    public void testSwap() throws Exception {
        Integer[] A = new Integer[]{1,2};
        swap(A,0,1);
        Assert.assertEquals(2, A[0].intValue());
        Assert.assertEquals(1, A[1].intValue());
    }

    @Test
    public void testQuickSort() {
        File file = new File("resources/QuickSort.txt");
        try {
            List<Integer> list = MyArrayUtil.ListIntegerFromFile(file);

            Integer[] A = list.toArray(new Integer[list.size()]);

            QuickSort.sortAndCountNumberOfSwaps(A);

            Assert.assertTrue(MyArrayUtil.checkArrayIntegerSorted(A));

        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            Assert.fail();
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
