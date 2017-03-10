package exercises;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Iterator;
import java.util.LinkedList;

class Entry {
	private Object key;
	private int value;
	Entry(Object k, int v) {
		key = k;
		value = v;
	}
	public Object getKey() { return key; }
	public int getValue() { return value; }
}

// assume keys of any type
// assume values of type int
class Hashtable {

	private LinkedList[] array;
	
	Hashtable() {
		array = new LinkedList[100];
	}

	private int computeIndexInArray(Object key) {
		// 1. compute hash value for key
		int hash = key.hashCode();
		// 2. compute remainder when dividing by array length
		int index = Math.abs(hash % array.length);
		return index;
	}

	void put(Object key, int value) {
		// 1. compute index
		int index = computeIndexInArray(key);
		// 2. check contents of array at index
		if (array[index] == null) {
			// insert new entry
			LinkedList list = new LinkedList();
			list.add(new Entry(key, value));
			array[index] = list;
		} else {
			// we know that `list` is not `null`
			LinkedList list = array[index];
			list.add(new Entry(key, value));
		}
	}
	
	private void throwAbsent(Object key) {
		throw new NoSuchElementException("no value for " + key + " in hash table");
	}

	/*boolean contains(Object key) {
		
    }*/

	int get(Object key) {
		// 1. compute index
		int index = computeIndexInArray(key);
		// 2. check contents of array at index
		if (array[index] == null) {
			throwAbsent(key);
		} else {
			LinkedList list = array[index];
			Iterator iter = list.iterator();
			while (iter.hasNext()) {
				Object elem = iter.next();
				Entry entry = (Entry) elem;
				if (entry.getKey() == key) {
					return entry.getValue();
				}
			}
			throwAbsent(key);
		}
		// Note: this code is unreachable, but Java compiler
		// not smart enough to detect that!
		return 0;
	}
	
	Optional<Integer> getMaybe(Object key) {
		// 1. compute index
		int index = computeIndexInArray(key);
		// 2. check contents of array at index
		if (array[index] == null) {
			return Optional.empty();
		} else {
			LinkedList list = array[index];
			Iterator iter = list.iterator();
			while (iter.hasNext()) {
				Object elem = iter.next();
				Entry entry = (Entry) elem;
				if (entry.getKey() == key) {
					return Optional.of(entry.getValue());
				}
			}
			return Optional.empty();
		}

	}
}

public class Hashtables {

	public static void main(String[] args) {
		Hashtable table = new Hashtable();
		table.put("Martin", 123);
		table.put("Jim", 456);
		
		int value = table.get("Martin");
		System.out.println("the value is " + value);
		
		Optional<Integer> result = table.getMaybe("Jim");
		System.out.println("result.isPresent(): " + result.isPresent());
		System.out.println("result.get(): " + result.get());
		
		Optional<Integer> result2 = table.getMaybe("Frank");
		System.out.println("result2.isPresent(): " + result2.isPresent());
		System.out.println("result2.get(): " + result2.get());
		
	}
}
