package study;

public class MaxMinDepthOfBinaryTree implements ISolution {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private TreeNode root = null;

	@Override
	public void setup() {
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.right.right = new TreeNode(8);
		root.right.right.left = new TreeNode(9);

	}

	private void printBinTree(TreeNode root) {
		java.util.Queue<TreeNode> q = new java.util.LinkedList<>();
		java.util.Queue<TreeNode> qNextLevel = new java.util.LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			while (!q.isEmpty()) {
				TreeNode n = q.poll();
				if (n == null) {
					System.out.print(" ");
				} else {
					System.out.print(n.val + " ");
					if (n.left != null) {
						qNextLevel.offer(n.left);
					} else {
						qNextLevel.offer(null);
					}
					if (n.right != null) {
						qNextLevel.offer(n.right);
					} else {
						qNextLevel.offer(null);
					}
				}
			}
			System.out.println("");
			if (!qNextLevel.isEmpty()) {
				q.addAll(qNextLevel);
				qNextLevel.clear();
			}
		}
	}

	@Override
	public void go() {
		printBinTree(root);
		System.out.println("Max Level:" + maxDepthLevel(root));
		System.out.println("Min Level:" + minDepthLevel(root));
	}

	private int maxDepthLevel(TreeNode node) {
		if (node == null)
			return 0;
		else {
			int leftLevel = maxDepthLevel(node.left) + 1;
			int rightLevel = maxDepthLevel(node.right) + 1;
			return Math.max(leftLevel, rightLevel);
		}
	}

	private int minDepthLevel(TreeNode node) {
		if (node == null)
			return 0;
		else {
			int leftLevel = minDepthLevel(node.left) + 1;
			int rightLevel = minDepthLevel(node.right) + 1;
			return Math.min(leftLevel, rightLevel);
		}
	}
}
