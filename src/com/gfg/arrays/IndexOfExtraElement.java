/**
 * 
 */
package com.gfg.arrays;

/**
 * @author akshayas
 *
 */
public class IndexOfExtraElement {

	public static void main(String[] args) {
		int arr1[] = { 2, 4, 6, 8, 10, 11, 12, 13 };
		int arr2[] = { 2, 4, 6, 8, 10, 12, 13 };
		int n = arr2.length;

		// Solve is passed both arrays
		System.out.println(getIndex(arr1, arr2, n));
	}

	static int getIndex(int[] a, int[] b, int n) {
		int low = 0, high = n - 1;
		int index = n;
		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (a[mid] == b[mid])
				low = mid + 1;
			else {
				index = mid;
				high = mid - 1;
			}
		}
		return index;
	}
}
