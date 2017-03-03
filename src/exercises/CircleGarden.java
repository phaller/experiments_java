package exercises;

public class CircleGarden {
	public double radius;
	public double getCost() {
		return 10 * radius * 2 * Math.PI;
	}
	public double getRevenue() {
		return 10 * radius * radius * Math.PI;
	}
}
