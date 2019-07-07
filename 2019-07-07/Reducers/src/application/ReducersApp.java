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
		
		Supplier<Integer> integerSupplier = ()-> new Integer(0);
		BiFunction<Integer,Integer,Integer> mergeSum = (s,x)->s+x;
		
		System.out.println(Reducers.reduce(ali, identity, integerSupplier, mergeSum, identity));
		
//		Supplier<IntAccumulator> accumulatorSupplier = () -> new IntAccumulator();
//		BiConsumer<IntAccumulator, Integer> mergeAver = (a, x) -> {a.setSum(a.getSum() + x); a.setN(a.getN() + 1);};
//		Function<IntAccumulator, Double> getAver = (a)-> ((double)a.getSum())/a.getN();
//
//		System.out.println(Reducers.reduce(ali, identity, accumulatorSupplier, mergeAver, getAver));

		Garage garage = new Garage();
		garage.fill(5);
		System.out.println(garage.allCars());

		Supplier<DoubleAccumulator> accumulatorSupplier = () -> new DoubleAccumulator();
		BiConsumer<DoubleAccumulator, Double> mergeEngine = (a, x) -> {a.setSum(a.getSum() + x); a.setN(a.getN() + 1);};
		Function<Car, Double> getEngine = (c)-> c.getEngine();
		Function<DoubleAccumulator, Double> getAver = (a)-> ((double)a.getSum())/a.getN();
		System.out.println(Reducers.reduce(garage.allCars(), getEngine, accumulatorSupplier, mergeEngine, getAver));

	}

}

	
	