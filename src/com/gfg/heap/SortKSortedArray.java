/**
 * 
 */
package com.gfg.heap;

import java.util.PriorityQueue;

/**
 * @author akshayas
 *
 */
public class SortKSortedArray {
	
	public static void main(String[] args) {
		int arr[] = {6, 5, 3, 2, 8, 10, 9};
		int k =3;
		sortArray(arr, arr.length, k);
		System.out.println(arr);
	}
	
	static void sortArray(int[] arr, int n, int k) {
		int count = 0;
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		for(int i=0; i<n; i++) {
			minHeap.add(arr[i]);
			if(minHeap.size()>k) {
				arr[count] = minHeap.poll();
				count++;
			}
		}
		
		for(int i=count; i<n;i++) {
			arr[i] = minHeap.poll();
		}
	}

}
