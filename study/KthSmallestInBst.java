package study;

import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class KthSmallestInBst implements ISolution {

	private TreeNode root = null;

	@Override
	public void setup() {
		/*
		 * 100 80 120 70 90 110 130
		 */

		root = new TreeNode(100);
		root.left = new TreeNode(80);
		root.right = new TreeNode(120);
		root.left.left = new TreeNode(70);
		root.left.right = new TreeNode(90);
		root.right.left = new TreeNode(110);
		root.right.right = new TreeNode(130);
	}

	@Override
	public void go() {
		int n = 3;
		System.out.println(String.format("%dth smallest number is %d", n, this.kthSmallest(root, n)));
		n = 1;
		System.out.println(String.format("%dth smallest number is %d", n, this.kthSmallest(root, n)));
		n = 5;
		System.out.println(String.format("%dth smallest number is %d", n, this.kthSmallest(root, n)));

		System.out.println("==========================");
		n = 3;
		System.out.println(String.format("%dth smallest number is %d", n, this.kthSmallestNoRecur(root, n)));
		n = 1;
		System.out.println(String.format("%dth smallest number is %d", n, this.kthSmallestNoRecur(root, n)));
		n = 5;
		System.out.println(String.format("%dth smallest number is %d", n, this.kthSmallestNoRecur(root, n)));
	}

	private int current;
	private TreeNode smallestNode;

	private int kthSmallestNoRecur(TreeNode root, int n) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		while (p != null) {
			stack.push(p);
			p = p.left;
		}
		while (n > 0 && !stack.isEmpty()) {
			TreeNode t = stack.pop();
			n--;
			if (n == 0) {
				return t.val;
			}
			p = t.right;
			while (p != null) {
				stack.push(p);
				p = p.left;
			}
		}
		return -1;
	}

	private int kthSmallest(TreeNode root, int n) {
		current = n;
		helper(root);
		if (smallestNode != null) {
			return smallestNode.val;
		} else {
			return -1;
		}
	}

	private void helper(TreeNode node) {
		if (node != null) {
			if (node.left != null) {
				helper(node.left);
			}
			current--;
			if (current == 0) {
				smallestNode = node;
				return;
			}
			if (node.right != null) {
				helper(node.right);
			}
		}
	}
}
