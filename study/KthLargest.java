package study;

import java.util.Arrays;

public class KthLargest implements ISolution {

	@Override
	public void setup() {

	}

	@Override
	public void go() {
		int a[] = { 2, 3, 1, 8, 4, 7, 6, 5 };
		int n = 3;
		System.out.println(Arrays.toString(a) + String.format(" %d th largest number is %d", n, nthLargest(a, n)));
		n = 4;
		System.out.println(Arrays.toString(a) + String.format(" %d th largest number is %d", n, nthLargest(a, n)));
	}

	private int nthLargest(int[] nums, int k) {
		return quickSelect(nums, k, 0, nums.length - 1);
	}

	private int quickSelect(int[] nums, int k, int left, int right) {
		int pos = partition(nums, left, right);
		if (pos == k - 1)
			return nums[pos];
		else if (pos < k - 1)
			return quickSelect(nums, k, pos + 1, right);
		else
			return quickSelect(nums, k, left, pos - 1);

	}

	private int partition(int[] nums, int left, int right) {
		int pivot = left++;
		while (left < right) {
			// find first number < pivot from left side
			while (left <= right && nums[left] >= nums[pivot]) {
				left++;
			}
			// find first number > pivot from right side
			while (left <= right && nums[right] <= nums[pivot]) {
				right--;
			}
			if (left > right)
				break;
			swap(nums, left, right);
		}
		swap(nums, pivot, right);
		return right;
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
