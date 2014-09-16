package utility;

/**
 * User: henry
 * Date: 8/18/13
 */
public class SimplePair<T> {

    private final T left;
    private final T right;

    public SimplePair(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getLeft() { return left; }
    public T getRight() { return right; }

//    @Override
//    public int hashCode() { return left.hashCode() ^ right.hashCode(); }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof SimplePair)) return false;
        SimplePair pair = (SimplePair) o;
        return this.left.equals(pair.getLeft()) &&
                this.right.equals(pair.getRight());
    }

}
