package miscellaneous;

import leetCode.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class ReverseLinkedListRecursiveTest {

    @Test
    public void testReverse() throws Exception {
        ListNode head = new ListNode(new int[]{12,99,37});
        Assert.assertEquals("37-99-12", ReverseLinkedListRecursive.reverse(head).toString());
    }
}