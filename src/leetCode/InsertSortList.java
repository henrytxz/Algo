/**
 *  12 July 2014: writing the code in an online editor took 44 mins 25 secs
 *  getting
 *  Input:	{3,2,4}
    Output:	{2,4}
    Expected:	{2,3,4}
    so spent 19:58 debugging it on paper first
    didn't find it, another 17.5 mins putting it into IntelliJ and step through a debugger to find the problem is
    the line marked by !!!!!
    DO NOT CONFUSE a NODE and a LIST!!!!!

    to rewrite this 13 July 2014
 */
public class InsertSortList {

    public static ListNode insertionSortList1(ListNode head) {
        if (head==null || head.next==null) return head; //0 or 1 element => nothing to do

        ListNode r = new ListNode(head.val);
        ListNode tail = r;
        ListNode i = head.next;
        while (i!=null) {
            if (i.val<r.val) {
                ListNode tmp = new ListNode(i.val);
                tmp.next = r;
                r = tmp;
            } else {
                ListNode prev = r;
                ListNode curr = r.next;

                while (curr!=null) {
                    if ( i.val < curr.val ) {
                        ListNode node = new ListNode(i.val);
                        prev.next = node;
                        node.next = curr;
                        break;
                    }
                    prev = curr;
                    curr = curr.next;
                }

                if (prev.val==tail.val) {
                    tail.next = new ListNode(i.val);
                    tail = tail.next;
                }
            }
            i = i.next;
        }
        return r;
    }

    /**
     *  the recursive method
     */
    public static ListNode insertionSortList2(ListNode head) {
        if (head==null || head.next==null) return head; //if the list has either 0 or 1 node, we're done

        ListNode result = new ListNode(head.val);
        ListNode current = result.next;
        while (current!=null) {
            result = insert(result, current);    //keep inserting till there's no more
            current = current.next;
        }
        return result;
    }

    public static ListNode insert(ListNode old, ListNode current) {
        assert current != null;

        if (old==null) {
            return current;
        }

        ListNode result;
        if (current.val < old.val) {
            result = new ListNode(current.val);
            result.next = old;
        } else {
            result = new ListNode(old.val);
            result.next = insert(old.next, current);
        }
        return result;
    }

    public static ListNode insertionSortList3(ListNode head) {
        if (head==null || head.next==null) return head; //if the list has either 0 or 1 node, we're done

        ListNode result = new ListNode(head.val);
        ListNode current = head.next;
        while (current!=null) {     //iterate through the input linked list
            boolean currentInserted = false;

            if (current.val <= result.val) {
                ListNode tmp = new ListNode(current.val);
                tmp.next = result;
                result = tmp;
            } else {
                ListNode nodeJustCompared = result;
                while (nodeJustCompared.next != null) {     //iterate through the already sorted nodes
                    if (current.val < nodeJustCompared.next.val) {
                        insertCurrentAfterNode(current, nodeJustCompared);
                        currentInserted = true;
                        break;
                    }
                    nodeJustCompared = nodeJustCompared.next;
                }
                if (!currentInserted) {
                    nodeJustCompared.next = new ListNode(current.val);
                }
            }
            current = current.next;
        }
        return result;
    }

    private static void insertCurrentAfterNode(ListNode current, ListNode node) {
        ListNode tmp = node.next;
        node.next = new ListNode(current.val);
        node.next.next = tmp;
    }
}
