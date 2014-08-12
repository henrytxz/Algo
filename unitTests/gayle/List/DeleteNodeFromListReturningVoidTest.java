package gayle.List;

import gayle.List.DeleteNodeFromListReturningVoid;
import junit.framework.Assert;
import leetCode.ListNode;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by henry on 8/12/2014.
 */
public class DeleteNodeFromListReturningVoidTest {
    @Test
    public void test_deleteNode() throws Exception {
        ListNode head = new ListNode(Arrays.asList(2, 3, 4));
        DeleteNodeFromListReturningVoid.deleteNode(head, 1);
        ListNode expected = new ListNode(Arrays.asList(2,3,4)); //1 not found
        Assert.assertEquals(expected, head);
    }

    @Test
    public void test_deleteNode1() throws Exception {
        ListNode head = new ListNode(Arrays.asList(1,2,3));
        DeleteNodeFromListReturningVoid.deleteNode(head, 1);
        ListNode expected = new ListNode(Arrays.asList(2,3)); //1 at head
        Assert.assertTrue(expected.equals(head));
    }

    @Test
    public void test_deleteNode2() throws Exception {
        ListNode head = new ListNode(Arrays.asList(2,1,3));
        DeleteNodeFromListReturningVoid.deleteNode(head, 1);
        ListNode expected = new ListNode(Arrays.asList(2,3)); //1 in the middle
        Assert.assertTrue(expected.equals(head));
    }

    @Test
    public void test_deleteNode3() throws Exception {
        ListNode head = new ListNode(Arrays.asList(2,3,1));
        DeleteNodeFromListReturningVoid.deleteNode(head, 1);
        ListNode expected = new ListNode(Arrays.asList(2,3)); //1 at the end
        Assert.assertTrue(expected.equals(head));
    }

    @Test
    public void test_deleteNode4() throws Exception {
        ListNode head = new ListNode(Arrays.asList(3,1,2,1,5,1));   //multiple 1s
        DeleteNodeFromListReturningVoid.deleteNode(head, 1);
        ListNode expected = new ListNode(Arrays.asList(3,2,5));
        Assert.assertTrue(expected.equals(head));
    }

    @Ignore //this will not pass unless ListNode has a way to let you construct a null node
    @Test
    public void test_deleteNode5() throws Exception {
        ListNode head = new ListNode(Arrays.asList(1));   //multiple 1s
        DeleteNodeFromListReturningVoid.deleteNode(head, 1);
        Assert.assertNull(head);
    }
}
