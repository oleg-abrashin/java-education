package model;

public class Point {
	
	private double x;
	private double y;
	
	public Point() {
		super();
	}

	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	public static double distance(Point p1, Point p2) {
		double diffX = p1.getX() - p2.getX();
		double diffY = p1.getY() - p2.getY();
		return Math.sqrt(diffX*diffX + diffY*diffY);
	}

	@Override
	public String toString() {
		return "x=" + x + ", y=" + y;
	}
}
