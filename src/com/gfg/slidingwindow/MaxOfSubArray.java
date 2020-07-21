/**
 * 
 */
package com.gfg.slidingwindow;

/**
 * @author akshayas
 *
 */
public class MaxOfSubArray {

	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, k = 3 ;
		maxOfSubArray(arr, k);
	}
	
	static void maxOfSubArray(int[] arr, int k) {
		int max_val = Integer.MIN_VALUE;
		int i;
		int count = 0;
		for(i=0; i<arr.length; i++) {
			count ++;
			if(max_val<arr[i])
				max_val = arr[i];
			
			if(count>k-1) {
				System.out.print(max_val + " ");
			}
		}
	}
}
