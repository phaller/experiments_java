package exercises;

public class Main {

	public static void main(String[] args) {
		Garden.fenceCost = 10;
		
		Garden.initLastId(100);
		
		SquareGarden g1 = new SquareGarden();
		g1.length = 2;
		
		CircleGarden g2 = new CircleGarden();
		g2.radius = 3;
		Garden g4 = SquareGarden.makeByPerimeter(g2.getPerimeter());
		g4 = SquareGarden.makeByPerimeter(100);
		
		RectGarden g3 = new RectGarden();
		g3.length= 3;
		g3.height= 2;
		
		printGarden(g1);
		printGarden(g2);
		printGarden(g3);
		
		Garden.fenceCost = 20;
		printGarden(g1);
		printGarden(g2);
		printGarden(g3);
		
	}
	
	public static void printGarden(Garden g) {
		//System.out.println("The shape is "+ g.getShape());
		System.out.println("Garden ID is " + g.id);
		if (g instanceof CircleGarden)
			System.out.println("The shape is CIRCLE");
		else if (g instanceof SquareGarden)
			System.out.println("The shape is SQUARE");
		else if (g instanceof RectGarden)
			System.out.println("The shape is RECTANGLE");
		System.out.println("Cost " + g.getCost() + " revenue" + g.getRevenue());
		
	}

}
