package predicates;

import java.util.function.Predicate;

public class MultipleOfFive implements Predicate<Integer>{

	@Override
	public boolean test(Integer i) {
		return i%5 == 0;
	}

}
