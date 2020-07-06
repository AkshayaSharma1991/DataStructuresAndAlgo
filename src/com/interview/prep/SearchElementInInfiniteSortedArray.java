/**
 * 
 */
package com.interview.prep;

/**
 * @author akshayas
 *
 */
public class SearchElementInInfiniteSortedArray {
	public static void main(String[] args) {
		int arr[] = new int[] { 3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170 };
		int ans = searchElement(arr, 10);
		System.out.println(ans);
	}

	static int searchElement(int[] a, int x) {
		int low = 0;
		int high = low + 1;

		while (low <= high) {
			if (a[high] == x)
				return high;
			else if (a[high] < x) {
				low = high;
				high = high * 2;
			} else {
				int mid = (low + high) / 2;
				if (a[mid] == x)
					return mid;
				else {
					if (a[mid] > x) {
						high = mid - 1;
					} else {
						low = mid + 1;
					}
				}
			}
		}

		return -1;
	}
}
