package miscellaneous;

import leetCode.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class ReverseLinkedListIterativeTest {

    @Test
    public void testReverse() throws Exception {
        ListNode head = new ListNode(new int[]{12,99,37});
        Assert.assertEquals("37-99-12", ReverseLinkedListIterative.reverse(head).toString());
    }
}