package application;

import java.util.Arrays;

import model.Circle;
import model.Point;

public class ThreeCirclesApp {

	public static void main(String[] args) {
		
		Circle c3 = new Circle(new Point(-1.0, 1.0), 2.0);
		Circle c2 = new Circle(new Point(-1.0, -1.0), 2.0);
		
		System.out.println(Arrays.toString(c3.intersectionPoints(c2)));
		
		Circle c1 = new Circle(new Point(2.8, 0.0), 2.0);
		
		System.out.println(Circle.haveCommonPoints(c1, c2, c3));
		
		
	}

}
