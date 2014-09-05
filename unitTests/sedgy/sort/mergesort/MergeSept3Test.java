package sedgy.sort.mergesort;

import org.junit.Assert;
import org.junit.Test;

public class MergeSept3Test {

    @Test
    public void testSort() throws Exception {
        int[] a = new int[]{8,5,3,1};
        MergeSept3.sort(a);
        Assert.assertArrayEquals(a, new int[]{1,3,5,8});

        a = new int[]{8,5,3,1,7};
        MergeSept3.sort(a);
        Assert.assertArrayEquals(a, new int[]{1,3,5,7,8});

        a = new int[]{8,5,3,1,7};
        MergeSept3.sort(a);
        Assert.assertArrayEquals(a, new int[]{1,3,5,7,8});

        a = new int[]{8};
        MergeSept3.sort(a);
        Assert.assertArrayEquals(a, new int[]{8});  //these are backwards, should be expected, actual but I won't bother with it now

        a = null;
        MergeSept3.sort(a);
        Assert.assertArrayEquals(null, a);
    }
}