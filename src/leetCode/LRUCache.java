package leetCode;

import java.util.*;

/**
 * Created by henry on 10/23/2014.
 */
public class LRUCache {
    /*
    Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

    get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
    set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
                      it should invalidate the least recently used item before inserting a new item.
    */

//    private List<Integer> keys;
//    private List<Integer> vals;
    private int numberOperationsSoFar = 0;
    private PriorityQueue<KeyAndOrder> orderPQ = new PriorityQueue<KeyAndOrder>();
    private Map<Integer, Integer> keyOrderMap = new HashMap<Integer, Integer>();
    private Map<Integer, Integer> keyValueMap = new HashMap<Integer, Integer>();
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public boolean contains(int key, int val) {
        return keyValueMap.get(key)==val;
    }

    public int get(int key) {
        Integer val = keyValueMap.get(key);
        if (val==null) return -1;
        int oldOrder = keyOrderMap.get(key);
        int newOrder = ++numberOperationsSoFar;
        keyOrderMap.put(key, newOrder);
        orderPQ.remove(new KeyAndOrder(key, oldOrder));
        orderPQ.add(new KeyAndOrder(key, newOrder));
        return val;
    }

    public void set(int key, int value) {
        int newOrder = ++numberOperationsSoFar;
        if (keyValueMap.size()==capacity) {
            KeyAndOrder ko = orderPQ.poll();
//            System.out.println("removing "+ko.key+","+ko.order);
            if (!keyValueMap.containsKey(key)) {
                keyValueMap.remove(ko.key);
                keyOrderMap.remove(ko.key);
            }
        }

        orderPQ.add(new KeyAndOrder(key, newOrder));
        keyOrderMap.put(key, newOrder);
        keyValueMap.put(key, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : keyValueMap.entrySet()) {
            sb.append("[");
            sb.append(entry.getKey());
            sb.append(":");
            sb.append(entry.getValue());
            sb.append("]");
            sb.append(",");
        }
        return sb.toString();
    }
}
