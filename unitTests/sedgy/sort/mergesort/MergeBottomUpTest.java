package sedgy.sort.mergesort;

import org.junit.Assert;
import org.junit.Test;

public class MergeBottomUpTest {

    @Test
    public void testSort() throws Exception {
        String[] a = new String[]{"M","E","R","G","E"};
        MergeBottomUp.sort(a);
        Assert.assertArrayEquals(new String[]{"E", "E", "G", "M", "R"}, a);
    }
}