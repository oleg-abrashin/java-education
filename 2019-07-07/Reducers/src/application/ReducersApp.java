package application;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import accumulators.DoubleAccumulator;
import accumulators.IntAccumulator;
import dto.Car;
import model.Garage;
import model.Reducers;

public class ReducersApp {

	public static void main(String[] args) {
		
		ArrayList<Integer> ali = new ArrayList<>();
		for (int i=10; i<16; i++)ali.add(i);

		Function<Integer,Integer> identity = x -> x;
		Supplier<IntAccumulator> factory = IntAccumulator::new;
		BiConsumer<IntAccumulator,Integer> accumulator =
				(a,d)->{a.setSum(a.getSum()+d);a.setN(a.getN()+1);};
		
		System.out.println(
				Reducers.reduce(ali,factory, accumulator).getSum()
		);


	}

}

	
	