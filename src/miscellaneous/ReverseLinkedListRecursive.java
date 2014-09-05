package miscellaneous;

import leetCode.ListNode;

/**
 * Created by henry on 9/3/2014.
 */
public class ReverseLinkedListRecursive {
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode following = head.next;
        ListNode l = reverse(following);
        following.next = head;
        head.next = null;
        return l;
    }

/*
    I coded my own version of recursive reverse then looked at
    http://www.programmerinterview.com/index.php/data-structures/reverse-a-linked-list/
    this code from the bottom of this page doesn't compile, it's missing a declaration of head
    but I do like the starred line and it helped me go from my code from version 1.0 to 2.0 :)

    public void recursiveReverse(Node currentNode )
    {
        //check for empty list
        if(currentNode == NULL)
            return;

         if we are at the TAIL node:
            recursive base case:

        if(currentNode.next == NULL)
        {
            //set HEAD to current TAIL since we are reversing list
            head = currentNode;
            return; //since this is the base case
        }

        recursiveReverse(currentNode.next);
        currentNode.next.next = currentNode;
        currentNode.next = null; //set "old" next pointer to NULL   //***   GOOD ONE :)
    }
*/
}
