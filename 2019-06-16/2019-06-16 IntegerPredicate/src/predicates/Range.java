package predicates;

import java.util.function.Predicate;

public class Range implements Predicate<Integer>{

	private int min;
	private int max;
	
	public Range(int min, int max) {
		super();
		this.min = min;
		this.max = max;
	}

	@Override
	public boolean test(Integer i) {
		return i >= min && i <= max;
	}

}
