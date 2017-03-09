package exercises;

class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
	TreeNode(int v, TreeNode l, TreeNode r) {
		this.value = v;
		this.left = l;
		this.right = r;
	}
	TreeNode(int v) {
		this.value = v;
		this.left = null;
		this.right = null;
	}
	void insert(int elem) {
		if (elem <= value) {
			if (left == null) {
				left = new TreeNode(elem);
			} else {
				left.insert(elem);
			}
		} else {
			if (right == null) {
				right = new TreeNode(elem);
			} else {
				right.insert(elem);
			}
		}
	}
	public String toString() {
		if (left == null && right == null) {
			return "Leaf(" + value + ")";
		} else {
			// not a leaf
			String leftString = (left == null) ? "<empty>" : left.toString();
			String rightString = (right == null) ? "<empty>" : right.toString();
			return "TreeNode(" + value + ", " + leftString + ", " +
					rightString + ")";
		}
	}
}

class BinaryTree {
	TreeNode root;
	BinaryTree() {
		this.root = null;
	}
	
	boolean isEmpty() {
		return root == null;
	}
	
	void insert(int elem) {
		if (root == null) {
			root = new TreeNode(elem);
		} else {
			root.insert(elem);
		}
	}
	
	@Override
	public String toString() {
		return root.toString();
	}
}

public class Trees {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.insert(10);
		tree.insert(8);
		tree.insert(5);
		tree.insert(1);
		System.out.println(tree);
		
		/*
		boolean result = method1() && method2();
		System.out.println("res1:" + result);

		boolean result2 = method1() & method2();
		System.out.println("res2:" + result2);
		*/
	}
	static boolean method1() {
		return true;
	}
	static boolean method2() {
		System.out.println("hi");
		return true;
	}
}
