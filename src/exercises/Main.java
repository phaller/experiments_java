package exercises;

public class Main {

	public static void main(String[] args) {
		SquareGarden g1 = new SquareGarden();
		g1.length = 2;
		
		CircleGarden g2 = new CircleGarden();
		g2.radius = 3;
		
		System.out.println("Cost " + g1.getCost() + " revenue" + g1.getRevenue());
		System.out.println("Cost " + g2.getCost() + " revenue" + g2.getRevenue());
	}

}
