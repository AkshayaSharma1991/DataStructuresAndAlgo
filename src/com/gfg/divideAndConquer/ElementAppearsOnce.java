/**
 * 
 */
package com.gfg.divideAndConquer;

/**
 * @author akshayas
 *
 */
public class ElementAppearsOnce {

	public static void main(String[] args) {
		int[] arr = {12,4,4,4};
		System.out.println(findElement(arr, arr.length));
	}
	
	static int findElement(int[] arr, int n) {
		return findElementRec(arr, n, 0, n-1);
	}
	
	static int findElementRec(int[] arr, int n ,int low, int high) {
		if(low>high)
			return -1;
		int mid = low + (high-low)/2;
		int prev = (mid+n-1)%n;
		int next = (mid+1)%n;
		
		if(arr[mid]!=arr[prev] && arr[mid]!=arr[next])
			return arr[mid];
		else {
			int left = findElementRec(arr, n, 0, mid-1);
			if(left !=-1)
				return left;
			return findElementRec(arr, n, mid+1,high);
		}
	}
}
