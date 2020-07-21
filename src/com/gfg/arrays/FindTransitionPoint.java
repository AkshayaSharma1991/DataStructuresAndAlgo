/**
 * 
 */
package com.gfg.arrays;

/**
 * @author akshayas
 *
 */
public class FindTransitionPoint {

	public static void main(String[] args) {
		int arr[] = {1,1,1,1,1};
		System.out.println(findTransitionPoint(arr, arr.length));
	}

	static int findTransitionPoint(int[] arr, int n) {
		int tp = 0;
		if (n != 0) {
			if (arr[0] != 1) {
				int low = 0, high = n - 1;
				boolean flag = false;
				while (low <= high) {
					int mid = low + (high - low) / 2;
					int prev = (mid + n - 1) % n;
					if (arr[prev] < arr[mid]) {
						tp = mid;
						flag = true;
						break;
					}
					if (arr[mid] == 0) {
						low = mid + 1;
					}
					if (arr[mid] == 1) {
						high = mid - 1;
					}
				}
				if (!flag)
					tp = -1;
			}
		}

		return tp;
	}
}
