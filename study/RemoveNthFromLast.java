package study;

class Node {
	int val;
	Node next;

	Node(int x) {
		val = x;
	}
}

public class RemoveNthFromLast implements ISolution {

	Node head;

	@Override
	public void setup() {
		System.out.println("=============================");
		int array[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		head = new Node(0);
		Node p = head;
		for (int a : array) {
			p.next = new Node(a);
			p = p.next;
		}
	}

	private void showList() {
		Node p = head.next;
		while (p != null) {
			System.out.print(String.format("%d,", p.val));
			p = p.next;
		}
		System.out.println();
	}

	@Override
	public void go() {
		setup();
		showList();
		removeFromEnd(head, 3);
		showList();

		setup();
		showList();
		removeFromEnd(head, 1);
		showList();

		setup();
		showList();
		removeFromEnd(head, 10);
		showList();
	}

	public Node removeFromEnd(Node head, int n) {
		Node p = head.next;
		Node pp = head;
		Node ppp = null;
		int x = 0;
		System.out.println("** Remove " + n + "th from end.");
		while (p != null) {
			if (x < n - 1) {
				p = p.next;
				x++;
			} else {
				p = p.next;
				ppp = pp;
				pp = pp.next;
			}
		}
		if (ppp != null) {
			ppp.next = ppp.next.next;
		}
		return head;
	}
}
