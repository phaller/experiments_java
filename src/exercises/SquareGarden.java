package exercises;

public class SquareGarden extends Garden {
	public double length;
	public double getPerimeter() {
		return length * 4;
	}
	public double getArea() {
		return length * length;
	}
}
