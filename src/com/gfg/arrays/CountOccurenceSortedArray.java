/**
 * 
 */
package com.gfg.arrays;

/**
 * @author akshayas
 *
 */
public class CountOccurenceSortedArray {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 2, 3, 3, 3, 3 };

		int x = 3;
		System.out.println(findLast(arr, arr.length, x) - findFirst(arr, arr.length, x) + 1);

	}

	static int findFirst(int[] arr, int n, int x) {
		int low = 0, high = n - 1;
		int index = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int prev = (mid + n - 1) % n;
			if (arr[mid] == x) {
				if (arr[mid] != arr[prev]) {
					index = mid;
					break;
				}
				high = mid - 1;
			}
			else if (arr[mid] < x) {
				low = mid + 1;
			} else
				high = mid - 1;

		}
		return index;
	}

	static int findLast(int[] arr, int n, int x) {
		int low = 0, high = n - 1;
		int index = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int next = (mid + 1) % n;
			if (arr[mid] == x) {
				if (arr[mid] != arr[next]) {
					index = mid;
					break;
				}
				low = mid + 1;
			}
			else if (arr[mid] < x) {
				low = mid + 1;
			} else
				high =  mid-1;
		}
		return index;
	}
}
