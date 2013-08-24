package UtilityClasses;

/**
 * Created with IntelliJ IDEA.
 * User: henry
 * Date: 8/18/13
 * Time: 11:39 AM
 * To change this template use File | Settings | File Templates.
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
        Pair pairo = (Pair) o;
        return this.left.equals(pairo.getLeft()) &&
                this.right.equals(pairo.getRight());
    }

}
