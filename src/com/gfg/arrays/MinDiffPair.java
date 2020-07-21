/**
 * 
 */
package com.gfg.arrays;

import java.util.Arrays;

/**
 * @author akshayas
 *
 */
public class MinDiffPair {

	public static void main(String[] args) {
		int arr[] = new int[]{1, 5, 3, 19, 18, 25}; 
        System.out.println("Minimum difference is "+ 
                              findMinDiff(arr, arr.length));
	}
	
	static int findMinDiff(int arr[], int n) {
		Arrays.sort(arr);
		int diff = Integer.MAX_VALUE;
		
		for(int i=1;i<n;i++) {
			if(arr[i] - arr[i-1] < diff) {
				diff = arr[i] -  arr[i-1];
			}
		}
		
		return diff;
	}
}
