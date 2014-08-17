package gayle.vimeo;

import org.junit.Assert;
import org.junit.Test;

public class FindMaxSumFromArrayTest {

    @Test
    public void testFindMaxSum2() throws Exception {
        int[] a = {1,3,-5,4,11,-2,8,-19,6};
        Assert.assertEquals(21, FindMaxSumFromArray.findMaxSum(a).intValue());
    }
}