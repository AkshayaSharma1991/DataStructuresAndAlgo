/**
 * 
 */
package com.gfg.binarysearch;

/**
 * @author akshayas
 *
 */
public class HighestNumberSortedRotated {

	public static void main(String[] args) {
		int[] arr= {1,21,23,24,2};
		System.out.println(findHighestNumber(arr, arr.length));
	}
	
	static int findHighestNumber(int[] arr, int n) {
		int low=0, high=n-1;
		int result = arr[high];
		while(low<= high) {
			int mid = low+(high-low)/2;
			int prev = (mid+n-1)%n;
			int next =  (mid+1)%n;
			
			if(arr[mid]>=arr[prev] &&  arr[mid]>=arr[next]) {
				result = arr[mid];
				break;
			} else if (arr[mid]>arr[high]) {
				low = mid+1;
			} else
				high = mid-1;
		}
		return result;
	}
}
