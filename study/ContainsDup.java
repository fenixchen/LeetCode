package study;

import java.util.Arrays;
import java.util.HashSet;

public class ContainsDup implements ISolution {

	@Override
	public void setup() {

	}

	@Override
	public void go() {
		{
			int a[] = { 1, 2, 3, 4, 5, 5, 6, 7, 8 };
			boolean h = hasDup(a);
			System.out.println(Arrays.toString(a) + (h ? " has " : " has not ") + "duplicated numbers");
		}
		{
			int a[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
			boolean h = hasDup(a);
			System.out.println(Arrays.toString(a) + (h ? " has " : " has not ") + "duplicated numbers");
		}
	}

	private boolean hasDup(int[] nums) {
		HashSet<Integer> s = new HashSet<Integer>();
		for (int i : nums) {
			if (s.contains(i))
				return true;
			else
				s.add(i);
		}
		return false;
	}

}
