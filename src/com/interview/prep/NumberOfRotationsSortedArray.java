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
		int[] a = {22,23,24,33,34,5};
		System.out.println("Rotations: " + numberOfRotations(a, a.length));
	}

	static int numberOfRotations(int[] arr, int n) {
		int low = 0, high = n - 1, index = -1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] < arr[mid - 1]) {
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
