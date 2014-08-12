/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
// 5 July 2014, took ~50 mins working it out on paper first then typed it in
/* 6 July 2014, did it in 36 mins 42 seconds
  - write it out on paper: 16:45
  - test it on paper: 12:20
  - write it online and verbally test: 7:35
*/

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null) { return l2; }
        if (l2==null) {return l1;}
        ListNode result;
        if (l1.val<=l2.val) {
            result = new ListNode(l1.val);
            l1 = l1.next;
        } else {
            result = new ListNode(l2.val);
            l2 = l2.next;
        }
        ListNode curr = result;
        
        while (!(l1==null&&l2==null)) {
            if (l1==null) {
                curr.next=l2;
                l2=null;
            } else if (l2==null) {
                curr.next=l1;
                l1=null;
            } else {
                if (l1.val<=l2.val) {
                    curr.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    curr.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
                curr = curr.next;
            }
        }
        
        return result;
    }
}
