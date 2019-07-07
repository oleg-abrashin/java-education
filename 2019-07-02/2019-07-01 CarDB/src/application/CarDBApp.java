package application;

import java.util.ArrayList;

import dto.Car;
import dto.CarComparators;
import model.Garage;

public class CarDBApp {
	
	private static final int NUM_NUM = 20;

	public static void main(String[] args) {
		/*Garage garage = new Garage();
		garage.fill(20);
		Car ccc = new Car(333333333, "Kia", 2003, 1.8, false);
		garage.add(ccc);
		
		for (Car c : garage.allCars()) System.out.println(c);
		System.out.println("********************************");
		garage.remove(ccc);
		for (Car c : garage.allCars()) System.out.println(c);
		System.out.println("********************************");
		for (Car c : garage.allCarsSortedByYear()) System.out.println(c);
	*/
		ArrayList<Car> alc = new ArrayList<>();
		for (int i=0; i<NUM_NUM; i++)alc.add(Car.randomCar());
		for (Car c : alc) System.out.println(c);
		System.out.println("*******************");
		alc.sort(CarComparators.modelCarComparator);
		for (Car c : alc) System.out.println(c);
	}
	

}
