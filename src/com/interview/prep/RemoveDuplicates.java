/**
 * 
 */
package com.interview.prep;

/**
 * @author akshayas
 *
 */

public class RemoveDuplicates {

	static int removeDuplicates(int arr[], int size) {
		if(size == 0 || size  ==1)
			return size;
		int j=0;
		for(int i=0;i<size-1; i++) {
			if(arr[i] != arr[i+1]) {
				arr[j]  = arr[i];
				j++;
			}
		}
		arr[j] = arr[size-1];
		j++;
		return j;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 2, 3, 4, 4, 4, 5, 5 };
		int n = arr.length;

		n = removeDuplicates(arr, n);

		// Print updated array
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}
}
