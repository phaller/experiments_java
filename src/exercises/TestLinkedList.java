package exercises;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLinkedList {

	@Test
	public void testSizeOfEmptyList() {
		LinkedList list = new LinkedList();
		int size = list.size();
		assertEquals(0, size);
	}
	
	@Test
	public void testSizeOfOneElementList() {
		LinkedList list = new LinkedList();
		list.add(5);
		int size = list.size();
		assertEquals(1, size);
	}

}
