package leetCode;

/**
 * Created by henry on 8/13/2014.
 */
public class SortListIterative {
    public ListNode sort(ListNode head) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        int numMerge = 0;
        for (int len=2; true; len*=2) {
            numMerge=0;
            ListNode loop = fakeHead;
            while (loop!=null && loop.next!=null) {
                loop = merge(loop, len);
                numMerge++;
            }
            if (numMerge<=1) break;
        }
        head = fakeHead.next;
        return head;
    }

    private ListNode merge(ListNode head, int len) {
        if (head==null||head.next==null) return null; //list has at least 2 nodes

        ListNode aBeg = head.next;
        ListNode aEnd = loopList(aBeg,len/2-1);    //does cpp round?
        if (aEnd==null) return null;    //when?

        ListNode bBeg = aEnd.next;
        aEnd.next = null;

        ListNode bEnd = loopList(bBeg, len/2-1);
        ListNode newEnd = bEnd==null ? null : bEnd.next;
        if (bEnd!=null) bEnd.next = null;

        ListNode loop = head;
        ListNode aLoop = aBeg;
        ListNode bLoop = bBeg;
        while (aLoop!=null || bLoop!=null) {
            ListNode next;
            if (aLoop==null) {
                next = bLoop;
            } else if (bLoop==null) {
                next = aLoop;
            } else {
                next = (aLoop.val<bLoop.val) ? aLoop : bLoop;
            }
            loop.next = next;
            loop = loop.next;

            if (next==aLoop) {
                aLoop = aLoop.next;
            } else if (next==bLoop) {
                bLoop = bLoop.next;
            }
        }
        loop.next = newEnd;
        return loop;
    }

    private ListNode loopList(ListNode head, int len) {
        while (head!=null && len-->0)
            head = head.next;
        return head;
    }
}
