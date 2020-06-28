/**
 * 
 */
package com.dsa.search;

import java.util.Arrays;

import com.dsa.sorting.BubbleSort;

/**
 * @author akshayas
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr  = new int[]{1,48,43,7,6,3,2};
		BubbleSort.sort(arr);
		System.out.println("BubbleSort: " + Arrays.toString(arr));
		
		System.out.println("48: " + BinarySearch.search(arr, 0, arr.length-1, 48));
		
		int[]  arr1= new int[] {10,20,30,40,50,60,42,32,22,12};
		System.out.println("Peak:" + BinarySearch.findPeak(arr1, 0, arr1.length-1));
		
		
		int[] arr2 = new int[] {10,10,10,20,20,20,20,30,40,50};
		System.out.println("FirstOccurence of 20: "  + BinarySearch.findFirstOccurence(arr2, 0, arr2.length-1, 20));
		System.out.println("LastOccurence of 20: "  + BinarySearch.findLastOccurence(arr2, 0, arr2.length-1, 20));
		
		int[] A = { 7, 2, 19, 3, 11, 6, 7, 8, 4 };
		Pair p = new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE);
		BinarySearch.findMinMax(A, 0, A.length - 1, p);
		System.out.println("Min of array: " + p.min);
		System.out.println("Max of array: " + p.max);

	}

}
