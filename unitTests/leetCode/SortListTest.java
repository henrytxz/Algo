import leetCode.ListNode;
import leetCode.SortList;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class SortListTest extends SortList {

    ListNode head;

    @Before
    public void setup() {
        head = new ListNode(Arrays.asList(4, 1, 3, 2));
        System.out.print("head is set up to be:");
        head.print();
    }

    @Test
    public void testSort() throws Exception {
        ListNode head0 = new ListNode(Arrays.asList(4, 1));
        sort(head0);
        head0.print();

        sort(head);
        head.print();
    }

    @Test
    public void testCrazy() throws Exception {
        ListNode foo = new ListNode(1);
        ListNode bar = new ListNode(2);
        foo.next = bar;
        bar.next = foo;
        System.out.println(foo);
    }

    @Test
    public void testMerge() throws Exception {
      merge(head,2,2,3);
//      merge(head,0,0,1);
      head.print();
    }
}