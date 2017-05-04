package study;

import java.util.Arrays;

public class PeakElement implements ISolution {

	@Override
	public void setup() {

	}

	@Override
	public void go() {
		int a[] = { 1, 2, 3, 1, 8, 4, 7, 6, 5, 0, 100, 200 };
		System.out.println("Peak element of " + Arrays.toString(a) + " is at " + peekElement(a));
		System.out.println("Peak element of " + Arrays.toString(a) + " is at " + peekElement2(a));

	}

	private int peekElement(int[] nums) {
		if (nums.length == 0) {
			return -1;
		} else if (nums.length == 1) {
			return 0;
		}
		for (int i = 0; i < nums.length; i++) {
			boolean peak;
			if (i == 0) {
				peak = nums[i] > nums[i + 1];
			} else if (i == nums.length - 1) {
				peak = nums[i] > nums[i - 1];
			} else {
				peak = nums[i] > nums[i - 1] && nums[i] > nums[i + 1];
			}
			if (peak) {
				return i;
			}
		}
		return 0;
	}

	private int peekElement2(int[] nums) {
		int left = 0;
		int right = nums.length;
		while (left <= right) {
			if (left == right) {
				return left;
			}
			int mid = (left + right) / 2;
			if (nums[mid] < nums[mid + 1]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return 0;
	}

}
