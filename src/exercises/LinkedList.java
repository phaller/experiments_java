package exercises;

class Node {
	int elem;
	Node next;

	Node(int x, Node n) {
		this.elem = x;
		this.next = n;
	}
}

public class LinkedList {

	Node first;
	
	LinkedList() {
		this.first = null;
		// not possible: new Node(??, null)
	}

	void add(int elem) {
		Node n = new Node(elem, null);
		// find last node of current list
				
		Node current = this.first;
		if (current == null) {
			this.first = n;
			return;
		}

		while (current.next != null) {
			current = current.next;
		}
		// current.next == null
		// here current is the last node!
		current.next = n;
	}

	int size() {
		int counter = 0;
		Node current = this.first;

		if (current == null) {
			return counter;
		} else {
			counter++;
		}

		while (current.next != null) {
			current = current.next;
			counter++;
		}
		return counter;
	}

	int get(int index) {
		if (index < 0) {
			throw new IllegalArgumentException("negative argument: " + index);
		} else if (index >= this.size()) {
			throw new IndexOutOfBoundsException("index: " + index);
		}

		int counter = 0;
		Node current = first;
		
		while (counter != index) {
			counter++;
			current = current.next;
		}
		
		return current.elem;
	}

	void remove(int elem) {
		
	}
	
	boolean find(int elem) {
		return false;
	}
}
