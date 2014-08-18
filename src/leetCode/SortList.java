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
        int length = 0;
        ListNode it = head;
        while (it!=null) {
            length++;
            it = it.next;
        }    //for test case 1: 4, 1, 3, 2 => length = 4
        return sort(head, 0, length-1);
    }

    private static ListNode sort(ListNode head, int lo, int hi)    //what would sort(head, 0, 1) do?    what would sort(head, 0, 2) do?    sort(head, 0, 3)    sort(head, 0, 4)
    {
        if (lo >= hi) return null;
        int mid = (lo+hi)/2;                //sort(head, 0, 1) => mid = 0                    mid=1                              mid = 1             mid = 2
        head = sort(head, lo, mid);                //sort(head, 0, 0)                               sort(head, 0, 1)                   sort(head, 0, 1)    sort(head, 0, 2)
        head = sort(head, mid+1, hi);              //sort(head, 1, 1)                               sort(head, 2, 2)                   sort(head, 2, 3)    sort(head, 3, 4)
        return merge(head, lo, mid, hi);
    }

    protected static ListNode merge(ListNode head, int lo, int mid, int hi)    //merge(0, 0, 1)
    {
        assert lo <= mid;
        assert mid <= hi;
        if (lo >= hi) return head;  //todo is null the right thing to return when method is not void?
        ListNode beforeLoNode = head;
        ListNode jNode = head;
        ListNode hiNode = head;
        for (int i=0; i<lo-1; i++) {	beforeLoNode = beforeLoNode.next; }
        ListNode iNode = beforeLoNode.next;
        if (lo==0) iNode = head; //special case
        for (int i=0; i<mid+1; i++) {	jNode = jNode.next; }
        for (int i=0; i<hi; i++) {	hiNode = hiNode.next; }
        ListNode afterHiNode = hiNode.next;
        ListNode result = new ListNode(0);
        ListNode resultHead = result;

        int iSteps = 0;
        int jSteps = 0;
        int lhTotal = mid-(lo-1);
        int rhTotal = hi-(mid+1-1);
        while (iSteps < lhTotal || jSteps < rhTotal) {
            if (iSteps == lhTotal) {
                result.next = jNode;
                jNode = jNode.next;
                jSteps++;
            } else if (jSteps == rhTotal) {
                result.next = iNode;
                iNode = iNode.next;
                iSteps++;
            } else if (iNode.val < jNode.val) {
                result.next = iNode;
                iNode = iNode.next;
                iSteps++;
            } else {
                result.next = jNode;
                jNode = jNode.next;
                jSteps++;
            }
            result = result.next;
        }

        result.next = afterHiNode;

//        if (lo==0) {
//            head.val = resultHead.next.val;
//            head.next = resultHead.next.next;
            return resultHead.next;
//        }
//        else beforeLoNode.next = resultHead.next;

//        return null;    //todo
    }
}
