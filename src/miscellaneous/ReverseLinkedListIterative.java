package miscellaneous;

import leetCode.ListNode;

/**
 * Created by henry on 9/2/2014.
 */
public class ReverseLinkedListIterative {
    public static ListNode reverse(ListNode head) {
        if (head==null || head.next==null) return head;

        ListNode n1 = head;
        ListNode n2 = n1.next;
        ListNode n3 = n2.next;

        head.next = null;
        while (true) {
            n2.next = n1;
            if (n3==null) {
                System.out.println("reversed list is "+n2);
                return n2;
            }
            n1 = n2;
            n2 = n3;
            n3 = n3.next;
        }
    }
}
