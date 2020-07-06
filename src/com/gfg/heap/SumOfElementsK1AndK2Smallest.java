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
public class SumOfElementsK1AndK2Smallest {

	public static void main(String[] args) {
		int arr[] = { 20, 8, 22, 4, 12, 10, 14 }, k1 = 3, k2 = 6;
		int n = arr.length;
		int first = kthSmallest(arr, n, k1);
		int second = kthSmallest(arr, n, k2);

		int sum = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] > first && arr[i] < second) {
				sum += arr[i];
			}
		}
		System.out.println(sum);
	}

	static int kthSmallest(int[] arr, int n, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < n; i++) {
			maxHeap.add(arr[i]);
			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}

		return maxHeap.poll();
	}
}
