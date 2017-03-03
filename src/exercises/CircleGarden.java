package exercises;

public class CircleGarden extends Garden {
	public double radius;
	public double getPerimeter() {
		return radius * 2 * Math.PI;
	}
	public double getArea() {
		return radius * radius * Math.PI;
	}
	public String getShape() {
		return "CIRCLE";
	}
	
	public CircleGarden() {
		this.id = getNewId();
	}
}
