package leetCode;

import leetCode.ListNode;

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
    public static void sort(ListNode head) {
        int length = 0;
        ListNode it = head;
        while (it!=null) {
            length++;
            it = it.next;
        }    //for test case 1: 4, 1, 3, 2 => length = 4
        sort(head, 0, length-1);
    }

    private static void sort(ListNode head, int lo, int hi)    //what would sort(head, 0, 1) do?    what would sort(head, 0, 2) do?    sort(head, 0, 3)    sort(head, 0, 4)
    {
        if (lo >= hi) return;
        int mid = (int) Math.floor((lo+hi)/2);    //sort(head, 0, 1) => mid = 0                    mid=1                              mid = 1             mid = 2
        sort(head, lo, mid);                //sort(head, 0, 0)                               sort(head, 0, 1)                   sort(head, 0, 1)    sort(head, 0, 2)
        sort(head, mid+1, hi);              //sort(head, 1, 1)                               sort(head, 2, 2)                   sort(head, 2, 3)    sort(head, 3, 4)
        merge(head, lo, mid, hi);
    }

    protected static void merge(ListNode head, int lo, int mid, int hi)    //merge(0, 0, 1)
    {
        assert lo <= mid;
        assert mid <= hi;
        if (lo == hi) return;

        System.out.println("running merge "+lo+","+mid+","+hi);
        // suppose a list looks like o  -o    -o    -o    -o     -o  -o
        //                              lo          mid  mid+1   hi
        //         a bit like          sort(head,0,2)    sort(head,3,4)   then merge(head, 0, 2, 4)
        //                              1      4    5  |  2      3        //my made up test case
        //before i do the list with 5 nodes
        //let me do                    -o    -o    -o    -o     -o
        //                                                3      2 in sort(head,3,4) then merge(head, 3, 3, 4)
        int M = mid - lo + 1;         //number of nodes in the left half
        int N = hi - mid;             //number of nodes in the right half

        int leftDone = 0;
        int rightDone = 0;


        if (lo==0) {
            ListNode newHead;
            ListNode i = new ListNode(head.val);
            i.next = head.next;
            ListNode before_j = i;
            for (int l = 0; l < M-1; l++) {
                before_j = before_j.next;
            }
            ListNode j = before_j.next;
            if (i.val<j.val) {
                newHead = new ListNode(i.val);
                i = i.next;
                leftDone++;
            } else {
                newHead = new ListNode(j.val);
                before_j.next = j.next;
                rightDone++;
            }
            ListNode it = newHead;  //constant space, specifically, 3*ListNode, 1 for newHead, 1 for i, 1 for it

            int count = 1;
            while (count < (hi - lo) + 1) {
                if (rightDone == N || (leftDone < M && i.val < j.val)) {
                    it.next = i;
                    i = i.next;
                    leftDone++;
                } else {
                    it.next = j;
                    j = j.next;
                    rightDone++;
                }
                count++;
                if (count < (hi-lo)+1) {
                    it = it.next;
                }
            }
//            it.next = j;
            head.val = newHead.val;
            head.next = newHead.next;
        } else {
            ListNode before_i = head;
            for (int l=0; l<lo-1; l++) {      //for eg, merge(head,2,2,3), l=0 => before_i goes from node 0 to node 1
                before_i = before_i.next;
            }
            merge(before_i.next, 0, M-1, M+N-1);
        }

//        ListNode i = prev.next;
//
//
//
//
//
//
//
//
//        ListNode it = head;
//
//        int count = 0;
//        while (count < (hi - lo) + 1) {
//            if (rightDone == N || (leftDone < M && i.val < j.val)) {
//                prev.next = i;
//                i = i.next;
//                leftDone++;
//            } else {
//                prev.next = j;
//                j = j.next;
//                rightDone++;
//            }
//            prev = prev.next;
//            count++;
//        }
//        prev.next = null;

    }
}
