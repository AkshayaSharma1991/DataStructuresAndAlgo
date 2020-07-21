/**
 * 
 */
package com.gfg.dp.bottomUp;

/**
 * @author akshayas
 *
 */
public class EqualSumPartition {
	public static void main(String[] args) {
		int arr[] = { 1,5, 11, 5 };
		int n = arr.length;
		System.out.println("Equal sum partion exists: " + equalSumPartition(arr, n));
	}
	
	static boolean equalSumPartition(int[] arr,  int n) {
		int sum = 0;
		for(int i=0; i<n;i++) {
			sum += arr[i];
		}
		if(sum % 2 != 0)
			return false;
		else {
			return  SubsetSumProblem.isSubsetExists(arr, sum/2, n);
		}
	}

}
