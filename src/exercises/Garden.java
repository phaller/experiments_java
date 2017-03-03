package exercises;

public abstract class Garden {
	public static double fenceCost;
	private static int lastid = 0;
	
	public static void initLastId(int val) {
		lastid = val;
	}
	
	public int id;
	
	public double getCost() {
		return fenceCost * getPerimeter();
	}
	public double getRevenue() {
		return 10 * getArea();
	}
	public abstract double getArea();
	public abstract double getPerimeter();
	public abstract String getShape();
	
	public int getNewId() {
		lastid+=1;
		return lastid;
	}
}
