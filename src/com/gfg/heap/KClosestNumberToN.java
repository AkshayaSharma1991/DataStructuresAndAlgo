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
public class KClosestNumberToN {

	public static void main(String[] args) {
		int arr[] = { 10, 2, 14, 4, 7, 6 };
		int x = 5, k = 3;
		int[] result = closestNumber(arr, arr.length, k, x);
		System.out.println(result);
	}

	static int[] closestNumber(int[] arr, int n, int k, int N) {
		PriorityQueue<PairInt> queue = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < n; i++) {
			queue.add(new PairInt(Math.abs(arr[i] - N), i));
			if (queue.size() > k) {
				queue.poll();
			}
		}

		int[] result = new int[k];
		int count = 0;
		while (!queue.isEmpty()) {
			result[count] = arr[queue.poll().second];
			count++;
		}
		return result;
	}
}

class PairInt implements Comparable<PairInt>{
	Integer first;
	Integer second;

	public PairInt(int x, int y) {
		first = x;
		second = y;
	}

	public int compareTo(PairInt p) {
		return this.first.compareTo(p.first);
	}
}
