/**
 * 
 */
package com.dsa.sorting;

/**
 * @author akshayas
 *
 */
public class BubbleSort {
	
	public static void  sort(int[]  arr) {
		boolean isSorted = false;
		int lastUnsorted = arr.length -1;
		while(!isSorted) {
			isSorted = true;
			for(int i=0; i<lastUnsorted;  i++) {
				if(arr[i] > arr[i+1])
					swap(arr, i,  i+1);
					isSorted  = false;
			}
			lastUnsorted --;
		}
	}
	
	static void swap(int[] arr, int i ,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	

}
