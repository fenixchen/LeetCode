package study;

public class ReverseInt implements ISolution {

	@Override
	public void setup() {

	}

	private int reverseInt(int n) {
		int ret = 0;
		while (n != 0) {
			if (ret * 10 > Integer.MAX_VALUE || ret * 10 < Integer.MIN_VALUE)
				return 0;
			ret = ret * 10 + (n % 10);
			n /= 10;
		}
		return ret;
	}

	@Override
	public void go() {
		int n = 12345;
		System.out.println("Reverse of " + n + " is " + reverseInt(n));
		n = 9876532;
		System.out.println("Reverse of " + n + " is " + reverseInt(n));
	}

}
