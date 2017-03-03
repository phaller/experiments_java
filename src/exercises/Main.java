package exercises;

public class Main {

	public static void main(String[] args) {
		SquareGarden g1 = new SquareGarden();
		g1.length = 2;
		
		CircleGarden g2 = new CircleGarden();
		g2.radius = 3;
		
		RectGarden g3 = new RectGarden();
		g3.length= 3;
		g3.height= 2;
		
		printGarden(g1);
		printGarden(g2);
		printGarden(g3);
		
	}
	
	public static void printGarden(Garden g) {
		System.out.println("Cost " + g.getCost() + " revenue" + g.getRevenue());
		
	}

}
