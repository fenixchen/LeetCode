package study;

public class PowerOf2 implements ISolution {

	@Override
	public void setup() {

	}

	@Override
	public void go() {
		int[] aa = { 100, 1024, 0, -1, 200 };
		for (int a : aa) {
			System.out.println(a + (isPowerOf2(a) ? " is " : " is not ") + "power of 2");
		}

	}

	private boolean isPowerOf2(int number) {
		return (number & (number - 1)) == 0;
	}

}
