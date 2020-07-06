/**
 * 
 */
package com.gfg.heap;

import java.util.PriorityQueue;

/**
 * @author akshayas
 *
 */
public class KLargestElementInArray {

	public static void main(String[] args) {
		int[] arr = { 7, 10, 4, 3, 20, 15 };
		int k = 3;

		int[] result = kLargestElements(arr, arr.length, k);
		System.out.println(result);
	}

	static int[] kLargestElements(int[] arr, int n, int k) {
		int[] result = new int[k];
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			minHeap.add(arr[i]);
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}
		for (int i = 0; i < k; i++) {
			result[i] = minHeap.poll();
		}
		return result;
	}
}
