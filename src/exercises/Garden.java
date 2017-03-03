package exercises;

public abstract class Garden {
	public double getCost() {
		return 10 * getPerimeter();
	}
	public double getRevenue() {
		return 10 * getArea();
	}
	public abstract double getArea();
	public abstract double getPerimeter();
}
