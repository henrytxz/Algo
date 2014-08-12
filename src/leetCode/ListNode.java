package leetCode;

import java.util.List;

/**
 *  Definition for singly-linked list.
 */

public class ListNode {
    public int val;
    public ListNode next;

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

    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof ListNode)) {   //a result of this is when both node0 and node1 are null, I'm returning false
            return false;
        }

        ListNode node1 = (ListNode) obj;
        ListNode node0 = this;
        while (node0!=null) {
            if (node1==null) return false;  //node1 is shorter than node0
            if (node0.val!=node1.val) return false;
            node0 = node0.next;
            node1 = node1.next;
        }
        if (node1==null) return true;
        else return false;  //node1 is longer than node0
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