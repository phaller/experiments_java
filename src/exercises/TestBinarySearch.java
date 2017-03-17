package exercises;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import static exercises.Search.*;
import org.junit.Test;

public class TestBinarySearch {

	@Test
	public void test() {
		int[] a = new int[3];
		a[0] = 5;
		a[1] = 7;
		a[2] = 2;
		boolean found = find(a, 10);
		assertEquals(false, found);
	}

	@Test
	public void testSearchAll() {
		int[] a = new int[10];
		long seed = 10L;
		Random rnd = new Random(seed);
		for (int i = 0; i < 10; i++) {
			a[i] = rnd.nextInt(100); 
		}
		Arrays.sort(a);
		for (int i = 0; i < 10; i++) {
			int valueToFind = a[i];
			boolean result = find(a, valueToFind);
			assertEquals(true, result);
		}
	}
}
