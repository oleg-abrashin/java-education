package application;

import dto.Car;
import model.Garage;

public class CarDBApp {
	
	public static void main(String[] args) {
		Garage garage = new Garage();
		garage.fill(20);
		Car ccc = new Car(333333333, "Kia", 2003, 1.8, false);
		garage.add(ccc);
		
		for (Car c : garage.allCars()) System.out.println(c);
		System.out.println("********************************");
		garage.remove(ccc);
		for (Car c : garage.allCars()) System.out.println(c);
		System.out.println("********************************");
		for (Car c : garage.allCarsSortedByYear()) System.out.println(c);
	}
	

}
