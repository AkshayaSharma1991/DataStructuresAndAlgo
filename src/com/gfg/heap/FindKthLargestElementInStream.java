/**
 * 
 */
package com.gfg.heap;

import java.util.PriorityQueue;

/**
 * @author akshayas
 *
 */
public class FindKthLargestElementInStream {

	public static void main(String[] args) {
		int[] arr = { 5, 15, 10, 20, 3 };
		int n = arr.length, k = 2;
		printKthLargest(arr, n, k);
	}

	static void printKthLargest(int[] arr, int n, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			minHeap.add(arr[i]);
			if(minHeap.size() == k)
				System.out.print(" " + minHeap.peek());
			else if (minHeap.size() > k) {
				minHeap.poll();
				System.out.print(" " + minHeap.peek());
			} else
				System.out.print(" " + -1);
		}
	}
}
