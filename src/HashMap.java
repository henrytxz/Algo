public class HashMap<K, V> {
    private K[] keys;
    private V[] vals;
    private int numberOfEntries;
    private int numberOfBuckets;
    private double loadFactor   = 0.75;    //how full the HT gets before adding buckets, 0.75 is the default load factor for Java's HashMap
    private double shrinkFactor = 0.25;    //how empty the HT gets before deleting buckets

    private static final int INITIAL_CAPACITY = 4;

    public HashMap() {
        keys = (K[]) new Object[INITIAL_CAPACITY];
        vals = (V[]) new Object[INITIAL_CAPACITY];
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
        System.out.println("updated keys["+i+"] to "+key+", val to "+val);
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
//            System.out.println("keys["+i+"]:"+keys[i]);
            if (keys[i].equals(key)) {
                keys[i] = null;
                vals[i] = null;
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

    public void print() {
        for (int i=0;i<numberOfBuckets;i++){
            System.out.println("keys["+i+"]:"+keys[i]);
        }
    }

    private void rehashCluster(int first) {
        int i = first;
        while (keys[i]!=null) {
            i = nextSlot(i);
        }

        for (int j=first; j!=i; j= nextSlot(j)) {
            K key = keys[j];
            V val = vals[j];
            keys[j] = null;
            vals[j] = null;
            put(key, val);
        }
    }

    private int nextSlot(int i) {
        return nextSlot(i, numberOfBuckets);
    }

    private int nextSlot(int i, int arrayLength) {
        return (i+1) % arrayLength;
    }

    public int getNumberOfEntries() {return numberOfEntries;}

    public int getNumberOfBuckets() {return numberOfBuckets;}

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
//        System.out.println(keys.length);
        for (int i=0; i!=keys.length; i++) {
            if (keys[i]!=null) {
                if (i==2)
                    System.out.println("pause");
                int newIndex = hash(keys[i]);
                while (newKeyArray[newIndex] != null) newIndex = nextSlot(newIndex, newKeyArray.length);
                newKeyArray[newIndex] = keys[i];
                newValArray[newIndex] = vals[i];
                System.out.println("updated newKeyArray[" + newIndex + "] to " + keys[i] + ", newValArray to " + vals[i]);
            }
        }
        keys = newKeyArray;
        vals = newValArray;
    }
}
