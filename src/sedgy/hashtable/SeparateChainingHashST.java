package sedgy.hashtable;

/**
 * Created by henry on 7/31/2014.
 */
public class SeparateChainingHashST<Key, Value> {
    private Node[] nodes;

    private int M = 97; //pick a prime

    public SeparateChainingHashST() {
        nodes = new Node[M];
    }

    public void put(Key key, Value value) {
        int index = hash(key);
        if (nodes[index]==null) {
            nodes[index] = new Node(key, value);
        } else {
            Node node = nodes[index];
            appendToList(node, key, value);
        }
    }

    public Value get(Key key) {
        int index = hash(key);
        Node n = nodes[index];
        while (n!=null) {
            if (n.key.equals(key)) return (Value) n.val;
            n = n.next;
        }
        return null;
    }

    private int hash(Key key) { return key.hashCode(); }
//    private int hash(Key key) { return 17; }

    //todo void delete(Key key)
    //todo boolean contains(Key key)
    //todo boolean isEmpty()
    //todo int size()
    //todo Iterable<Key> keys()

    private void appendToList(Node node, Key key, Value value) {
        while (node.next != null) {
            node = node.next;
        }
        node.next = new Node(key, value);
    }

    private static class Node {     //static => read about inner classes todo
        private Object key;
        private Object val;
        private Node next;

        private Node(Object key, Object val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }

    private static class Cell<K, V>     //Gayle CTCI p312
    {
        private K key;
        private V val;
        public Cell(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }
}
