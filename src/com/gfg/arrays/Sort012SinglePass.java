/**
 * 
 */
package com.gfg.arrays;

/**
 * @author akshayas
 *
 */
public class Sort012SinglePass {

	public static void main(String[] args) {
		int[] arr = {1,2,2,2,2,2,0,0,0,0,0,1,1,1,1,1};
		sort012(arr);
		System.out.println(arr);
	}
	
	static void sort012(int[] arr) {
		int low =0, mid =0;
		int high = arr.length-1;
		
		while(mid<=high) {
			if(arr[mid]==0) {
				swap(arr,mid,low);
				mid++;
				low++;
			} else if(arr[mid]==1)
				mid++;
			else {
				swap(arr,  mid, high);
				high--;
			}
		}
	}
	
	static void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] =  arr[y];
		arr[y] = temp;
	}
}
