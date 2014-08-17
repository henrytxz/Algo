package gayle.list;

import leetCode.ListNode;

/**
 * Created by henry on 8/12/2014.
 */
public class DeleteNodeFromListReturningVoid {
    public static void deleteNode(ListNode head, int val) {
        if (head==null) return;
        if (head.val == val) {
            if (head.next!=null) {
                head.val  = head.next.val;
                head.next = head.next.next;
            } else {
                // one node only and it has val => result should be a null list
                head = null;    //this won't do anything to the caller because head is a value copy (of the object reference)
            }
            return;
        }
        ListNode n = head;
        while (n.next!=null) {
            if (n.next.val==val) {
                n.next = n.next.next;
            }
            if (n.next==null) break;
            n = n.next;
        }
    }
}