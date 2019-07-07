package model;

public class Circle {
	
	private Point center;
	private double radius;
	
	public Circle() {
		super();
	}

	public Circle(Point center, double radius) {
		super();
		this.center = center;
		this.radius = radius;
	}

	public boolean includesPoint(Point p) {
		return Point.distance(center, p) <= radius;
	}
	
	public boolean includesCircle(Circle c) {
		return Point.distance(center, c.center) <= Math.abs(radius - c.radius);
	}
	
	public boolean hasCommonPoints(Circle c) {
		return Point.distance(center, c.center) <= radius + c.radius;
	}
	
	public Point[] intersectionPoints(Circle c) {
		if (!hasCommonPoints(c) || includesCircle(c)) return new Point[0];
		
		double distance = Point.distance(center, c.center);
		double x1 = center.getX();
		double y1 = center.getY();
		double cosA = (c.center.getX() - x1)/distance;
		double sinA = (c.center.getY() - y1)/distance;
		
		double toHorde = (radius*radius - c.radius*c.radius + distance*distance)/2./distance;
		double halfHorde = Math.sqrt(radius*radius - toHorde*toHorde);
		
		double xc = x1 + toHorde*cosA;
		double yc = y1 + toHorde*sinA;
		
		Point[] result = {new Point (xc - halfHorde*sinA, yc + halfHorde*cosA), 
				          new Point (xc + halfHorde*sinA, yc - halfHorde*cosA)};
		return result;			        
	}
	
	public static boolean haveCommonPoints(Circle c1, Circle c2, Circle c3) {
		
		if (! (c1.hasCommonPoints(c2) && c1.hasCommonPoints(c3) && c2.hasCommonPoints(c3))) return false;
		
		if ( 	(c1.includesCircle(c2) && c3.hasCommonPoints(c2)) || 
				(c1.includesCircle(c3) && c2.hasCommonPoints(c3)) ||
				(c2.includesCircle(c1) && c3.hasCommonPoints(c1)) || 
				(c2.includesCircle(c3) && c1.hasCommonPoints(c3)) ||
				(c3.includesCircle(c1) && c2.hasCommonPoints(c1)) || 
				(c3.includesCircle(c2) && c1.hasCommonPoints(c2)) ) return true;
		
		Point[] intersections = c1.intersectionPoints(c2);
		if (c3.includesPoint(intersections[0]) || c3.includesPoint(intersections[1]))return true;
		intersections = c1.intersectionPoints(c3);
		if (c2.includesPoint(intersections[0]) || c2.includesPoint(intersections[1]))return true;
		intersections = c2.intersectionPoints(c3);
		if (c1.includesPoint(intersections[0]) || c1.includesPoint(intersections[1]))return true;
		
		return false;
			
	}
	
	@Override
	public String toString() {
		return "center: " + center + "; radius=" + radius;
	}
	
	

}
