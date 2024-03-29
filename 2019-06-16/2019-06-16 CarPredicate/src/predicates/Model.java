package predicates;

import java.util.function.Predicate;

import car.Car;

public class Model implements Predicate<Car>{
	
	private String model;

	public Model(String model) {
		super();
		this.model = model;
	}

	@Override
	public boolean test(Car c) {
		return c.getModel().equals(model);
	}

}
