package gayle.list;

import leetCode.ListNode;

/**
 * Created by henry on 8/12/2014.
 */
public class DeleteNodeFromList {
    public static ListNode deleteNode(ListNode head, int val) {
        if (head == null) return head;
        if (head.val == val) return head.next;
        ListNode n = head;
        while (n.next!=null) {
            if (n.next.val==val) {
                n.next = n.next.next;
            }
            if (n.next==null) break;    //when this is true, n becomes null in the next line, then n.next will fail in the while condition. but is there a more elegant way than this line?
            n = n.next;
        }
        return head;
    }
}
