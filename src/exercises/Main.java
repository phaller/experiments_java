package exercises;

public class Main {

	public static void main(String[] args) {
		Garden.fenceCost = 10;
		
		Garden.initLastId(100);
		
		SquareGarden g1 = new SquareGarden();
		SquareGarden g2 = new SquareGarden();
		RectGarden g3 = new RectGarden();
		try {
			g3.setMeasurements(10, -1);
		}
		catch (WrongHeight ex) {
			System.out.println(ex.getMessage());
		}
		catch (WrongLength ex) {
			System.out.println(ex.getMessage());
		}
	
	}
	
	public static void print(Garden g1) {
		System.out.println(" Revenure ration: " + (int)g1.getRevenue()/(int)g1.getCost());
	}

}

//try {
//}
//catch (ArithmeticException ex) {
//System.out.println(" Failed to compute the ratio");
//}
