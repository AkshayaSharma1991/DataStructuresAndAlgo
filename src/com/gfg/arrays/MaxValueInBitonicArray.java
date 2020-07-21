/**
 * 
 */
package com.gfg.arrays;

/**
 * @author akshayas
 *
 */
public class MaxValueInBitonicArray {

	public static void main(String[] args) {
		int arr[] = { 120, 100, 80, 20, 0 };
		System.out.println("The maximum element is " + maxValue(arr, arr.length));
	}

	static int maxValue(int[] arr, int n) {
		int low = 0, high = n - 1;
		int max = 0;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int prev = (mid + n - 1) % n;
			int next = (mid + 1) % n;

			if (arr[mid] > arr[prev] && arr[mid] > arr[next]) {
				max = arr[mid];
			}
			if (arr[mid] < arr[next] && arr[mid] > arr[prev]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return max;
	}

}
