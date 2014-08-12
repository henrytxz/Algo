import java.util.List;

/**
 *  Definition for singly-linked list.
 */

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(List<Integer> integers) {
        if (integers.size()==0)
            return;

        this.val = integers.get(0);
        if (integers.size()>1)
            this.next = new ListNode(integers.subList(1, integers.size()));
    }

    public void print() {
        System.out.print(val);
        System.out.print("-");
        ListNode nxt = this.next;
        while (nxt!=null) {
            System.out.print(nxt.val);
            System.out.print("-");
            nxt = nxt.next;
        }
        System.out.println();
    }
}