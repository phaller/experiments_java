package exercises;

public class SquareGarden {
	public double length;
	public double getCost() {
		return 10 * length * 4;
	}
	public double getRevenue() {
		return 10 * length * length;
	}
}
