package comparators;

import java.util.Comparator;

public class EvenOddComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer i1, Integer i2) {
		boolean evency1 = i1%2 == 0;
		boolean evency2 = i2%2 == 0;
		if (evency1 == evency2) {
			return evency1 ? i2 - i1 : i1 - i2;
		}
		return evency1 ? -1 : 1;
	}

}
