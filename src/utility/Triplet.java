package utility;

public class Triplet<T> {

	private final T first;
	private final T second;
	private final T third;
	
	public Triplet(T first, T second, T third) {
		this.first = first;
		this.second = second;
		this.third = third;
	}

	public T getFirst() {return first;}
	public T getSecond() {return second;}
	public T getThird() {return third;}
	public boolean contains(T element) {
        return element==first||element==second||element==third;
    }
}
