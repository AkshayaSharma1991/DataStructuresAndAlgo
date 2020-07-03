/**
 * 
 */
package com.interview.prep;

/**
 * @author akshayas
 *
 */
public class SearchElementInCircularArray {
	public static void main(String[] args) {
		int[] a = { 22, 3, 4, 5, 6, 7 };
		System.out.println("Index: " + searchElement(a, a.length, 22));
	}

	static int searchElement(int[] a, int n, int x) {
		int low = 0, high = n - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (a[mid] == x)
				return mid;
			else if (a[mid] <= a[high]) {
				if (x > a[mid] && x < a[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			} else if (a[low] <= a[mid]) {
				if (x > a[mid] && x < a[low]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return -1;
	}
}
