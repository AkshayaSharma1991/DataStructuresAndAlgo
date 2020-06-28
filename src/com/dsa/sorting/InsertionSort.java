/**
 * 
 */
package com.dsa.sorting;

/**
 * @author akshayas
 *
 */
public class InsertionSort {
	
	static void sort(int[] arr) {
		int n  = arr.length;
		int  j, val;
		for(int  pos= 1; pos<=n-1; pos++) {
			val = arr[pos];
			j = pos -1;
			while(j >=0 && arr[j] > val) {
				arr[j+1] = arr[j];
				j--;
			}
			
			arr[j+1] = val;
		}
	}

}
