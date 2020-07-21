/**
 * 
 */
package com.gfg.binarysearch;

/**
 * @author akshayas
 *
 */
public class FloorOfSortedArray {

	public static void main(String[] args) {
		int[] arr= {1};
		System.out.println(getFloor(arr, arr.length,21));
	}
	
	static int getFloor(int[] arr, int n, int x) {
		int low  =0, high=n-1;
		int floor = Integer.MAX_VALUE;
		while(low<=high) {
			int mid  = low+(high-low)/2;
			if(arr[mid] == x) {
				floor = arr[mid];
				break;
			}else if(arr[mid]<x) {
				floor = arr[mid];
				low = mid +1;
			}else {
				high= mid-1;
			}
		}
		return floor;
	}
}
