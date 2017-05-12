package study;

import java.util.Arrays;

public class DuplicatedNum implements ISolution {

	@Override
	public void setup() {

	}

	@Override
	public void go() {
		{
			int a[] = { 1, 3, 9, 5, 6, 8, 9, 2, 4, 9 };
			int d = getDup(a);
			System.out.println(Arrays.toString(a) + " dup number:" + d);
		}
	}

	private int getDup(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			System.out.printf("left:%d, right:%d, mid:%d\n", left, right, mid);
			int count = 0;
			for (int n : nums) {
				if (n <= mid) {
					count++;
				}
			}
			if (count <= mid) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}

}
