package gayle.List;

import leetCode.ListNode;

/**
 * Created by henry on 8/12/2014.
 */
public class ReverseList {
    public static ListNode reverse(ListNode n) {
        if (n==null) return n;
        if (n.next==null) return n;

        if (n.next.next==null) {
            ListNode result = n.next;
            result.next = n;
            n.next = null;
            return result;
        } else {
            ListNode result = reverse(n.next);
            ListNode it = result;
            while(it.next!=null) {
                it = it.next;
            }
            it.next = n;
            n.next = null;
            return result;
        }
    }
}
