package study;

import java.util.Arrays;

public class QSort implements ISolution {

	@Override
	public void setup() {

	}

	@Override
	public void go() {
		int a[] = { 2, 3, 1, 8, 4, 7, 6, 5, 0, 100, 200 };
		System.out.println("Before sort:" + Arrays.toString(a));
		quickSort(a, 0, a.length - 1);
		System.out.println("After sort:" + Arrays.toString(a));

		int b[] = { 2, 3, 1, 8, 4, 7, 6, 5, 0, 100, 200 };
		System.out.println("Before sort:" + Arrays.toString(b));
		quickSort2(b, 0, b.length - 1);
		System.out.println("After sort:" + Arrays.toString(b));

	}

	private void quickSort2(int[] nums, int left, int right) {
		if (left < right) {
			int l = left, r = right, x = nums[l];
			while (l < r) {
				while (l < r && nums[r] <= x) {
					r--;
				}
				if (l < r) {
					nums[l++] = nums[r];
				}
				while (l < r && nums[l] >= x) {
					l++;
				}
				if (l < r) {
					nums[r--] = nums[l];
				}
			}
			nums[l] = x;
			quickSort2(nums, left, l - 1);
			quickSort2(nums, l + 1, right);
		}
	}

	private void quickSort(int[] nums, int left, int right) {
		if (left >= right)
			return;
		int p = partition(nums, left, right);
		quickSort(nums, left, p - 1);
		quickSort(nums, p + 1, right);
	}

	private int partition(int[] nums, int left, int right) {
		int pivot = left++;
		while (left < right) {
			while (left <= right && nums[left] >= nums[pivot]) {
				left++;
			}
			while (left <= right && nums[right] <= nums[pivot]) {
				right--;
			}
			if (left < right) {
				swap(nums, left, right);
			}
		}
		if (nums[pivot] < nums[right]) {
			swap(nums, pivot, right);
		}
		return right;
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
