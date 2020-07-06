/**
 * 
 */
package com.gfg.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author akshayas
 *
 */
public class KthSmallestElement {

	public static void main(String[] args) {
		int[] arr = { 7, 10, 3, 4, 15, 20, 25 };
		System.out.println(kthSmallest(arr, arr.length, 3));
	}

	static int kthSmallest(int[] arr, int n, int k) {

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < n; i++) {
			maxHeap.add(arr[i]);
			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}

		return maxHeap.peek();
	}
}
