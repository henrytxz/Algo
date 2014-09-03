package miscellaneous;

import leetCode.ListNode;

/**
 * Created by henry on 9/3/2014.
 */
public class ReverseLinkedListRecursive {
    public static ListNode reverse(ListNode head) {
//        if (head==null || head.next==null) return head;
//        ListNode n2 = head.next;
//        ListNode rest = recursiveReverse(n2);
//        n2.next

        ListNode reverse = recursiveReverse(head);
        head.next = null;
        return reverse;
    }

    private static ListNode recursiveReverse(ListNode curr) {
        if (curr == null || curr.next == null) return curr;
        ListNode following = curr.next;
        ListNode rest = recursiveReverse(following);
        following.next = curr;
        return rest;
    }
}
