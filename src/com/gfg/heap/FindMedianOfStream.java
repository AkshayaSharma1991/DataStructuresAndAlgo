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
public class FindMedianOfStream {

	public static void main(String[] args) {
		// stream of integers
		int[] arr = new int[] { 5, 15, 10, 20, 3 };
		printMedian(arr, arr.length);
	}

	static void printMedian(int[] arr, int n) {
		double med = arr[0];
		System.out.println(med);
		PriorityQueue<Integer> smaller = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> greater = new PriorityQueue<>();
		smaller.add(arr[0]);
		for (int i = 1; i < n; i++) {
			int x = arr[i];

			// 3 cases: case 1: left heap is larger than the right heap
			if (smaller.size() > greater.size()) {
				if (x < med) {
					greater.add(smaller.poll());
					smaller.add(x);
				} else
					greater.add(x);
				// Cast this to double. 	VERY IMPORTANT TO GET ACCURATE MEDIAN
				med =(double) (smaller.peek() + greater.peek()) / 2;
			}

			// case 2: smaller and greater are equal in size
			else if (smaller.size() == greater.size()) {
				if (x < med) {
					smaller.add(x);
					med = smaller.peek();
				} else {
					greater.add(x);
					med = greater.peek();
				}
			}
			// case 3: right is larger than the left
			else {
				if (x < med) {
					smaller.add(x);
				} else {
					smaller.add(greater.poll());
					greater.add(x);
				}
				med = (double)(smaller.peek() + greater.peek()) / 2;
			}
			System.out.println(med);
		}
	}
}
