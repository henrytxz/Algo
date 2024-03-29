package utility;

/**
 * User: henry
 * Date: 8/18/13
 */
public class Pair<L,R> {

    private final L left;
    private final R right;

    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public L getLeft() { return left; }
    public R getRight() { return right; }

//    @Override
//    public int hashCode() { return left.hashCode() ^ right.hashCode(); }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof Pair)) return false;
        Pair pair = (Pair) o;
        return this.left.equals(pair.getLeft()) &&
                this.right.equals(pair.getRight());
    }

}
