package gayle.List;

import leetCode.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ReverseListTest {

    @Test
    public void testReverse() throws Exception {
        ListNode n1 = null;
        Assert.assertNull(ReverseList.reverse(n1));

        ListNode n2 = new ListNode(Arrays.asList(1));
        Assert.assertEquals(n2, ReverseList.reverse(n2));

        ListNode n3 = new ListNode(Arrays.asList(1,2));
        ListNode n3R = new ListNode(Arrays.asList(2,1));
        Assert.assertEquals(n3R, ReverseList.reverse(n3));

        ListNode n4 = new ListNode(Arrays.asList(1,2,3,4));
        ListNode n4R = new ListNode(Arrays.asList(4,3,2,1));
        Assert.assertEquals(n4R, ReverseList.reverse(n4));
    }
}