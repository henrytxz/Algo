package coreJava;

import leetCode.KeyAndOrder;
import org.junit.Test;

import java.util.PriorityQueue;

/**
 * Created by henry on 10/24/2014.
 */
public class PriorityQueueTest {
    @Test
    public void test() {
        PriorityQueue<KeyAndOrder> pq = new PriorityQueue<KeyAndOrder>(3, KeyAndOrder.BY_ORDER);
        pq.add(new KeyAndOrder(1,1));
        pq.add(new KeyAndOrder(2,2));
        pq.add(new KeyAndOrder(3,3));
        pq.remove(new KeyAndOrder(1,1));
        System.out.println(pq.peek());
    }
}
