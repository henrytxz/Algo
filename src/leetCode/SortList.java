package leetCode;

/**
 * Created by henry on 8/2/2014.

     suppose i have 4-1-3-2, a list of 4 nodes
     let me try merge sort
     sort(head, 0, 1)
     sort(head, 2, 3)

     if i have 5-4-1-3-2, a list of 5 nodes
     i would want
     => length = 5
     sort(head, 0, 1)
     sort(head, ...)
 */
public class SortList {
    public static ListNode sort(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode beforeSlow = head;
        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while (true) {										//could have said while(fast!=null&&fast.next!=null)
            if (fast==null || fast.next==null) break;
            beforeSlow = beforeSlow.next;
            slow = slow.next;
            fast = fast.next.next;
        }
        beforeSlow.next = null;

        ListNode left  = sort(head);
        ListNode right = sort(slow);
        return merge(left, right);
    }

    private static ListNode merge(ListNode left, ListNode right) {

        ListNode result = new ListNode(0);
        ListNode itr = result;
        while (left!=null||right!=null) {
            if (left==null) {
                itr.next = right;
                right = null;
            } else if (right==null) {
                itr.next = left;
                left = null;
            } else if (left.val <= right.val) {
                itr.next = left;
                itr = itr.next;
                left = left.next;
                itr.next = null;	//so itr is as expected in each iteration
            } else {
                itr.next = right;
                itr = itr.next;
                right = right.next;
                itr.next = null;
            }
        }
        return result.next;
    }
}
