/**
 * 
 */
package com.gfg.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author akshayas
 *
 */
public class ElementsInRange {
	
	public static void main(String[] args) {
		int arr[] = {10, 12, 11, 15}, 
			       low = 10, high = 15;
		printElements(arr, high, low);
	}
	
	static void printElements(int[] arr, int high, int low) {
		Set<Integer> hs = new HashSet<>();
		
		for(int i=0; i<arr.length;i++) {
			hs.add(arr[i]);
		}
		
		for(int i=low;i<high;i++) {
			if(!hs.contains(i))
				System.out.println(i + " ");
		}
	}

}
