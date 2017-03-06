package exercises;

import java.io.*;
import java.util.ArrayList;

class MalformedGarden extends Exception {}

class WrongHeight extends Exception {}

class WrongLength extends Exception {}

class Phone {
	void callSomebody() {}
}

public class Main {

	public static void main(String[] args) {
		Garden.fenceCost = 10;
		
		Garden.initLastId(100);
		
		SquareGarden g1 = new SquareGarden();
		SquareGarden g2 = new SquareGarden();
		RectGarden g3 = new RectGarden();
		try {
			g3.setMeasurements(10, 20);
		}
		catch (WrongHeight ex) {
			System.out.println(ex.getMessage());
		}
		catch (WrongLength ex) {
			System.out.println(ex.getMessage());
		}

		ArrayList list = new ArrayList();
		list.add(g1);
		list.add(g2);
		list.add(g3);

		PrintWriter writer = null; // this is OK here, because of the initialization below
		try {
			writer = new PrintWriter(new FileWriter("Gardens.txt"));
			for (Object element : list) {
				Garden g = (Garden) element;
				System.out.println("writing garden " + element);
				writer.println("Garden with shape " + g.getShape() + ", perim.: " + g.getPerimeter());
			}
			writer.flush();
		} catch (ClassCastException cce) {
			System.out.println("tried to do an invalid cast");
			cce.printStackTrace();
		} catch (FileNotFoundException fnfe) {
			System.out.println("Could not create file");
			fnfe.printStackTrace();
			System.out.println("cause: " + fnfe.getCause());
			System.out.println("message: " + fnfe.getMessage());
		} catch (IOException ioe) {
			System.out.println("could not write to file");
			System.out.println("cause: " + ioe.getCause());
		} finally {
			if (writer != null)
				writer.close();
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
