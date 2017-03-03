package exercises;

public class RectGarden extends Garden {
	public double length;
	public double height;
	public double getPerimeter() {
		return 2*(length+height);
	}
	public double getArea() {
		return (length*height);
	}
	public String getShape() {
		return "RECTANGLE";
	}
	public RectGarden() {
		this.id = getNewId();
	}
}
