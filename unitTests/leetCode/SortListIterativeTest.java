package leetCode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class SortListIterativeTest extends SortListIterative {

    ListNode head;

    @Before
    public void setup() {
        head = new ListNode(Arrays.asList(4, 1, 3, 2));
//        System.out.print("head is set up to be:");
//        head.print();
    }

    @Test
    public void testSort() throws Exception {
        ListNode head0 = sort(new ListNode(Arrays.asList(4, 1)));
        Assert.assertEquals(new ListNode(Arrays.asList(1,4)), head0);

        head = sort(head);
        Assert.assertEquals(new ListNode(Arrays.asList(1,2,3,4)), head);
    }

}