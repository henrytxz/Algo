package gayle.list;

import leetCode.ListNode;
import utility.Pair;

/**
 * Created by henry on 8/12/2014.
 */
public class ReverseList {
    public static ListNode reverse(ListNode n) {
        if (n==null) return n;
        if (n.next==null) return n;
        return reverse2(n).getLeft();
    }

    /*
        in this Pair, left is head and right is tail
     */
    private static Pair<ListNode, ListNode> reverse2(ListNode n) {
        assert n!=null;
        assert n.next!=null;
        if (n.next.next==null) {
            ListNode result = n.next;
            result.next = n;
            n.next = null;
            return new Pair<ListNode, ListNode>(result, n);
        } else {
            Pair<ListNode,ListNode> pair = reverse2(n.next);
            ListNode result = pair.getLeft();
            ListNode tail = pair.getRight();
            tail.next = n;
            n.next = null;
            return new Pair<ListNode, ListNode>(result, n);
        }
    }
}
