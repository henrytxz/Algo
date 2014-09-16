package otherquestions;

import leetCode.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class ReverseLinkedListIterativeTest {

    @Test
    public void testReverse() throws Exception {
        ListNode head = new ListNode(new int[]{12,99,37});
        Assert.assertEquals("37-99-12", ReverseLinkedListIterative.reverse(head).toString());

        head = new ListNode(new int[]{1,2,3,4});
        Assert.assertEquals("4-3-2-1", ReverseLinkedListIterative.reverse(head).toString());
    }
}