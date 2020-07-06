/**
 * 
 */
package com.interview.prep;

/**
 * @author akshayas
 *
 */
public class FloorofElementInSortedArray {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 8, 10, 10, 12, 19 };
		int x = 5;
		System.out.println("Floor:  " + getFloor(arr, arr.length, x));
	}

	static int getFloor(int[] arr, int n, int x) {
		int low = 0;
		int high = n - 1;
		int result = Integer.MIN_VALUE;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == x)
				return arr[mid];
			else {
				if (arr[mid] > x) {
					high = mid - 1;
				} else {
					low = mid + 1;
					result = Math.max(result, arr[mid]);
				}
			}
		}
		return result;
	}
}
