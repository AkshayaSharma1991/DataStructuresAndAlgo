/**
 * 
 */
package com.interview.prep;

/**
 * @author akshayas
 *
 */
public class MergeKSortedArrays {

	public static void main(String[] args) {
		int[][] arr = { { 0,  2, 6, 12, 34 }, { 1, 9, 20, 1000 }, { 23, 34, 90, 2000, 3000 } };

		System.out.println("Merged array is :");
		mergeKSortedArrays(arr);
	}

	static void mergeKSortedArrays(int[][] arr) {
		MinHeap mh = new MinHeap();
		int resultSize = 0;
		for (int i = 0; i < arr.length; i++) {
			HeapNode h = new HeapNode(arr[i][0], i, 1);
			mh.add(h);
			resultSize += arr[i].length;
		}
		
		int[] result = new int[resultSize];
		for(int i=0; i<resultSize;i++) {
			HeapNode h  = mh.pop();
			result[i] = h.element;
			if(h.j < arr[h.i].length) {
				mh.add(new HeapNode(arr[h.i][h.j++], h.i, h.j++));
			}
			else
				mh.add(new HeapNode(Integer.MAX_VALUE, h.i, h.j++));
		}
		
		for(int i=0;  i<resultSize; i++) {
			System.out.print(" " + result[i]);
		}
	}
}
