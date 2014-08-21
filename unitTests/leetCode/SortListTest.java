package leetCode;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class SortListTest extends SortList {

    ListNode head;

    @Before
    public void setup() {
        head = new ListNode(Arrays.asList(4, 1, 3, 2));
    }

    @Test
    public void testSort() throws Exception {
        ListNode head0 = new ListNode(Arrays.asList(4, 1));
        ListNode actual = sort(head0);
        ListNode expected = new ListNode(Arrays.asList(1, 4));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSort2() throws Exception {
        ListNode actual = sort(head);
        ListNode expected = new ListNode(Arrays.asList(1,2,3,4));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSort3() throws Exception {
        ListNode original = new ListNode(Arrays.asList(5,4,1,3,2));
        ListNode actual = sort(original);
        ListNode expected = new ListNode(Arrays.asList(1,2,3,4,5));
        Assert.assertEquals(expected, actual);
    }

//    to turn into a comment, be careful about circular references
//    @Test
//    public void testCrazy() throws Exception {
//        ListNode foo = new ListNode(1);
//        ListNode bar = new ListNode(2);
//        foo.next = bar;
//        bar.next = foo;
//        foo.print();
//    }

}