/**
 * 
 */
package com.interview.prep;

/**
 * @author akshayas
 *
 */
public class NumberOfRotationsSortedArray {

	public static void main(String[] args) {
		int[] a = {20,23,23,25,26,2,3,4,5};

		System.out.println("Rotations: " + numberOfRotations(a, a.length));
	}

	static int numberOfRotations(int[] arr, int n) {
		int low = 0, high = n - 1, index = -1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			int prev = (mid + n - 1) % n;
			int next = (mid + 1) % n;
			if (arr[mid] <= arr[prev] && arr[mid] <= arr[next]) {
				index = mid;
				break;
			} else if (arr[mid] > arr[high]) {
				low = mid + 1;
			} else
				high = mid - 1;
		}

		return index;
	}
}
