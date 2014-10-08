public class HashMap<K, V> {
    private K[] keys;
    private V[] vals;
    private int numberOfEntries;
    private int numberOfBuckets;
    private double loadFactor   = 0.75;    //how full the HT gets before adding buckets, 0.75 is the default load factor for Java's HashMap
    private double shrinkFactor = 0.25;    //how empty the HT gets before deleting buckets

    private static final int INITIAL_CAPACITY = 4;

    /**
     * use the default initial capacity none specified
     */
    public HashMap() {
        this(INITIAL_CAPACITY);
    }

    public HashMap(int initialCapacity) {
        keys = (K[]) new Object[initialCapacity];
        vals = (V[]) new Object[initialCapacity];
        numberOfBuckets = keys.length;
        numberOfEntries = 0;
    }

    public void put(K key, V val) {
        int i = hash(key);
        if (keys[i]!=null && keys[i].equals(key)) { vals[i]=val; return; }
        while (keys[i]!=null) { i = nextSlot(i); }
        keys[i] = key;
        vals[i] = val;
        numberOfEntries++;
        if (numberOfEntries == loadFactor * numberOfBuckets) {
            resize(2 * numberOfBuckets);
        }
    }

    public V get(K key) {
        if (numberOfEntries ==0) return null;
        int i = hash(key);
        while (true) {
            if (keys[i] == null) return null;
            else if (keys[i].equals(key)) return vals[i];
            else i = nextSlot(i);
        }
    }

    public void remove(K key) {
        int i=hash(key);
        while (keys[i]!=null) {
            if (keys[i].equals(key)) {
                remove(i);
                if (numberOfEntries == shrinkFactor*numberOfBuckets) {
                    resize(numberOfBuckets/2);
                } else {
                    rehashCluster(nextSlot(i));
                }
                return;
            }
            i= nextSlot(i);
        }
    }

    private void rehashCluster(int first) {
        int i = first;
        while (keys[i]!=null) {
            i = nextSlot(i);
        }

        for (int j=first; j!=i; j= nextSlot(j)) {
            K key = keys[j];
            if (key!=null) {
                V val = vals[j];
                remove(j);
                put(key, val);
            }
        }
    }

    private void remove(int i) {
        keys[i] = null;
        vals[i] = null;
        numberOfEntries--;
    }

    private int nextSlot(int i) {
        return nextSlot(i, numberOfBuckets);
    }

    private int nextSlot(int i, int arrayLength) {
        return (i+1) % arrayLength;
    }

    /**
     *  & 0x7fffffff makes sure the integer returned is non-negative and hence a valid array index
     */
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % numberOfBuckets;
    }

    private void resize(int newSize) {
        numberOfBuckets = newSize;
        K[] newKeyArray = (K[]) new Object[newSize];
        V[] newValArray = (V[]) new Object[newSize];
        for (int i=0; i!=keys.length; i++) {
            if (keys[i]!=null) {
                int newIndex = hash(keys[i]);
                while (newKeyArray[newIndex] != null) newIndex = nextSlot(newIndex, newKeyArray.length);
                newKeyArray[newIndex] = keys[i];
                newValArray[newIndex] = vals[i];
            }
        }
        keys = newKeyArray;
        vals = newValArray;
    }
}
