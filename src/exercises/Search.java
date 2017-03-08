package exercises;

public class Search {

	static boolean find(int[] a, int elem) {
		int pos = 0;
		while (pos < a.length) {
			if (a[pos] == elem) {
				return true;
			}
		    pos++;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] a = new int[3];
		a[0] = 5;
		a[1] = 7;
		a[2] = 2;
		boolean found = find(a, 10);
		System.out.println(found);
	}
	
	
	// assume array `a` is sorted
	// left = left boundary
	// right = right boundary
	private static boolean binsearch(int[] a, int left, int right, int elem) {
		int index = (right - left) / 2;
		
		if (a[left + index] == elem)
			return true;

		if (right - left == 1) return false;

		if (a[left + index] > elem) {
			// search in left half
			return binsearch(a, left, index-1, elem);
		} else {
			// search in right half
			return binsearch(a, index+1, right, elem);
		}
	}
	
	public static boolean search(int[] a, int elem) {
		return binsearch(a, 0, a.length, elem);
	}
}
