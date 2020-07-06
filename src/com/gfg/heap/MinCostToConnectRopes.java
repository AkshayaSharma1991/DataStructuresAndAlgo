/**
 * 
 */
package com.gfg.heap;

import java.util.PriorityQueue;

/**
 * @author akshayas
 *
 */
public class MinCostToConnectRopes {

	public static void main(String[] args) {
		int[] ropes = { 1,2,3,4,5};
		System.out.println(minCost(ropes, ropes.length));
	}

	static int minCost(int[] ropes, int n) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			minHeap.add(ropes[i]);
		}
		int sum = 0;
		while (minHeap.size() > 1) {
			int rope1 = minHeap.poll();
			int rope2 = minHeap.poll();
			sum += rope1 + rope2;
			minHeap.add(rope1 + rope2);
		}

		return sum;
	}
}
