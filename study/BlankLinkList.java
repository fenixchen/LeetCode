package study;

public class BlankLinkList implements ISolution {
	class LinkNode {
		int val;
		LinkNode next;

		public LinkNode(int v) {
			val = v;
			next = null;
		}

	}

	private LinkNode head = null;

	@Override
	public void setup() {
		head = new LinkNode(-1);
		head.next = new LinkNode(1);
		head.next.next = new LinkNode(2);
		head.next.next.next = new LinkNode(3);
		head.next.next.next.next = new LinkNode(4);
		head.next.next.next.next.next = new LinkNode(5);
		head.next.next.next.next.next.next = new LinkNode(6);

	}

	private void printLinkList(LinkNode head) {
		LinkNode p = head.next;
		boolean first = true;
		while (p != null) {
			if (first) {
				first = false;
			} else {
				System.out.print(" -> ");
			}
			System.out.print(p.val);
			p = p.next;
		}
		System.out.println();
	}

	@Override
	public void go() {
		printLinkList(head);
	}
}
