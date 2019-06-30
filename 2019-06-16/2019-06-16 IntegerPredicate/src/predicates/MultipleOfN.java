package predicates;

import java.util.function.Predicate;

public class MultipleOfN implements Predicate<Integer>{
	
	private int n;

	public MultipleOfN(int n) {
		super();
		this.n = n;
	}

	@Override
	public boolean test(Integer i) {
		return i%n == 0;
	}

}
