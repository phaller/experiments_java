package exercises;

import java.nio.charset.MalformedInputException;

public class SquareGarden extends Garden {
	public double length;
	public double getPerimeter() {
		return length * 4;
	}
	public double getArea() {
		return length * length;
	}
	public String getShape() {
		return "SQUARE";
	}
	
	public SquareGarden() {
		this.id = getNewId();
	}

	public static SquareGarden makeByPerimeter(double per) {
		SquareGarden sq = new SquareGarden();
		sq.length = per/4;
		return sq;
	}
	public void setLength(double i) throws MalformedGarden {
		if (i > 0)
			this.length = i;
		else {
			throw new MalformedGarden();
		}
	}
}
