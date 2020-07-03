/**
 * 
 */
package com.interview.prep;

/**
 * @author akshayas
 *
 */
public class KthSmallestElementInUnsortedList {
	/**
	 * Given an array arr[] and a number K where K is smaller than size of array,
	 * the task is to find the Kth smallest element in the given array. It is given
	 * that all array elements are distinct.
	 * 
	 * Approach 1: Apply merge sort and get the k-1th element T: O(nlogn) S:O(1) App
	 * 2: Quick sort terminating when partition index is k-1th element
	 */
	public static void main(String[] args) {
		int[] arr = { 7, 10, 4, 3, 20, 15 };
		int k = 3;
		System.out.println(findkthSmallest(arr, 0, arr.length - 1, k));
	}

	static int findkthSmallest(int[] arr, int l, int r, int k) {
		if (k > 0 && k <= r - l + 1) {
			int partition = partition(arr, l, r);
			if (partition - l == k - 1)
				return arr[partition];
			if (partition - l > k - 1)
				return findkthSmallest(arr, l, partition - 1, k);
			
			//  Understand this;
			return findkthSmallest(arr, partition + 1, r, k - partition + l - 1);
		}
		return Integer.MAX_VALUE;
	}

	static int partition(int[] arr, int l, int r) {
		int x = arr[r], i = l - 1;
		for (int j = l; j <= r - 1; j++) {
			if (arr[j] <= x) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i+1];
		arr[i+1] = x;
		arr[r] = temp;

		return i+1;
	}
}
