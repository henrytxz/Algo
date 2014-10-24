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
    private int leastRecentOrder = 0;
    private PriorityQueue<KeyAndOrder> order = new PriorityQueue<KeyAndOrder>();
    private Map<Integer, Integer> keyOrderMap = new HashMap<Integer, Integer>();
    private Map<Integer, Integer> keyValueMap = new HashMap<Integer, Integer>();
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
//        keys = new LinkedList<Integer>();
//        vals = new LinkedList<Integer>();
//        keyValueMap = new HashMap<Integer, Integer>();
    }

    public int get(int key) {
        Integer val = keyValueMap.get(key);
        boolean keyFound = (val != null);
        if (keyFound) {
            makeKeyMostRecent(key);
            return val;
        } else return -1;

//        for (int i=0; i!=keys.size(); i++) {
//            if (key==keys.get(i)) {
//                int val = vals.get(i);
//                if (i!=keys.size()-1) {
//                    keys.remove(i);
//                    vals.remove(i);
//                    keys.add(key);
//                    vals.add(val);
//                }
//                return val;
//            }
//        }
//        return -1;
    }

    private void makeKeyMostRecent(int key) {
        numberOperationsSoFar++;

        boolean keyAlreadyExists = (keyOrderMap.get(key) != null);
//        if (keyAlreadyExists) {
//            if (keyOrderMap.get(key)==leastRecentOrder) {
//                leastRecentOrder
//            }
//        }

        keyOrderMap.put(key, numberOperationsSoFar);

//        keyOrderMap.put(key, )
//        for (int i=0; i!=keys.size(); i++) {
//            if (key==keys.get(i)) {
//                keys.remove(i);
//                keys.add(key);
//            }
//        }
    }

    public void set(int key, int value) {
        if (keyValueMap.containsKey(key)) {
            keyValueMap.put(key, value);
            makeKeyMostRecent(key);
        } else {
//            keyValueMap.put(key, value);

            if (keyValueMap.size()==capacity) {
                KeyAndOrder ko = order.poll();
                keyValueMap.remove(ko.key);
//                keys.remove(0);
            }
//            keys.add(key);
        }

//        for (int i=0; i!=keys.size(); i++) {
//            if (key==keys.get(i)) {
//                vals.set(i, value);
//                return;
//            }
//        }
//        if (keys.size()==capacity) {
//            keys.remove(0);
//            vals.remove(0);
//        }
//        keys.add(key);
//        vals.add(value);
    }

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        for (int i=0; i!=keys.size(); i++) {
//            sb.append("[");
//            sb.append(keys.get(i));
//            sb.append(":");
//            sb.append(keyValueMap.get(keys.get(i)));
//            sb.append("]");
//            if (i!=keys.size()-1) {
//                sb.append(",");
//            }
//        }
//        return sb.toString();
//    }
}
