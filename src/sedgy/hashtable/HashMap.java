package sedgy.hashtable;

/**
 * Created by henry on 10/4/2014.
 */
public class HashMap<K, V> {
    private K[] keys;
    private V[] vals;
    private int numberOfEntries;
    private int numberOfBuckets;
    private double loadFactor;      //how full the HT gets before adding buckets
    private double shrinkFactor;    //how empty the HT gets before deleting buckets     todo

    private static final int INITIAL_CAPACITY = 4;

    public HashMap() {
        keys = (K[]) new Object[INITIAL_CAPACITY];
        vals = (V[]) new Object[INITIAL_CAPACITY];
        numberOfBuckets = keys.length;
        numberOfEntries = 0;
        loadFactor = 0.75;  //0.75 is the default load factor for Java's HashMap
    }

    public void put(K key, V val) {
        int i = hash(key);
        if (keys[i]!=null && keys[i].equals(key)) { vals[i]=val; return; }
        while (keys[i]!=null) i=(i+1) % numberOfBuckets;
        keys[i] = key;
        vals[i] = val;
        numberOfEntries++;
        if (numberOfEntries == loadFactor * numberOfBuckets) {
            resize(2 * numberOfBuckets);
//            keys = resize(keys, 2* numberOfBuckets);
//            vals = resize(vals, 2* numberOfBuckets);
        }
    }

    public V get(K key) {
        if (numberOfEntries ==0) return null;
        int i = hash(key);
        while (true) {
            if (keys[i] == null) return null;
            else if (keys[i].equals(key)) return vals[i];
            else i = (i + 1) % numberOfBuckets;
        }
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
        for (int i=0; i<keys.length && keys[i]!=null; i++) {
            int newIndex = hash(keys[i]);
            newKeyArray[newIndex] = keys[i];
            newValArray[newIndex] = vals[i];
        }
        keys = newKeyArray;
        vals = newValArray;
    }

//    private <T> T[] resize(T[] a, int newSize) {
//        T[] newArray = T[newSize];
//
//    }
}
