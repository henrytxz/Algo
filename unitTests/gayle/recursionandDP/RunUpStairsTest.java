package gayle.recursionandDP;

import junit.framework.Assert;
import org.junit.Test;

public class RunUpStairsTest {

    @Test
    public void testCount() throws Exception {
        RunUpStairs runUpStairs = new RunUpStairs();
        Assert.assertEquals(0, runUpStairs.count(-1));
        Assert.assertEquals(1, runUpStairs.count(0));
        Assert.assertEquals(1, runUpStairs.count(1));
        Assert.assertEquals(2, runUpStairs.count(2));
        Assert.assertEquals(4, runUpStairs.count(3));
    }
}