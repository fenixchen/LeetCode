package study;

import java.util.Arrays;

public class RotateArray implements ISolution {

	@Override
	public void setup() {

	}

	@Override
	public void go() {
		{
			int a[] = { 1, 3, 9, 5, 6, 8, 9, 2, 4, 9 };
			int n = 3;
			System.out.println(Arrays.toString(a));
			rotateArray(a, n);
			System.out.println("Rotate:" + n);
			System.out.println(Arrays.toString(a));
		}
	}

	private void rotateArray(int[] nums, int n) {
		reverse(nums, 0, n - 1);
		reverse(nums, n, nums.length - 1);
		reverse(nums, 0, nums.length - 1);

	}

	private void reverse(int[] nums, int left, int right) {
		while (left < right) {
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			right--;
		}
	}

}
