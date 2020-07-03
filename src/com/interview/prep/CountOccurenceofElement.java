/**
 * 
 */
package com.interview.prep;

/**
 * @author akshayas
 *
 */
public class CountOccurenceofElement {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 3, 5, 5, 5, 5, 5, 5, 5, 77 };
		int firstIndex = binarySearch(a, a.length, 4, true);
		if (firstIndex != -1) {
			int secondIndex = binarySearch(a, a.length, 4, false);
			int count = (secondIndex - firstIndex) + 1;
			System.out.println("Count of 4: " + count);
		} else
			System.out.println("Count of 4: 0");
	}

	static int binarySearch(int[] a, int n, int x, boolean isFirst) {
		int low = 0, high = n - 1, result = -1;

		while (high >= low) {
			int mid = (high + low) / 2;
			if (a[mid] == x) {
				result = mid;
				if (isFirst)
					high = mid - 1;
				else
					low = mid + 1;
			} else if (x < a[mid]) {
				high = mid - 1;
			} else
				low = mid + 1;
		}
		return result;
	}

}
