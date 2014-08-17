package sedgy.sort.mergesort;

import org.junit.Assert;
import org.junit.Test;

public class MergeTest extends Merge {

    @Test
    public void test() {
        String[] a = new String[]{"M","E","R","G","E"};
        String[] b = new String[a.length];
        merge(a, b, 0, 0, 1);
    }

    @Test
    public void testSort() throws Exception {
        String[] a = new String[]{"M","E","R","G","E"};
        sort(a);
        Assert.assertArrayEquals(new String[]{"E","E","G","M","R"}, a);
    }
}