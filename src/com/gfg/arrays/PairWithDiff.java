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
public class PairWithDiff {

	public static void main(String[] args) {
		int arr[] = {5, 20, 3, 2, 50, 80};
		int n = 78;
		findPair(arr, arr.length, n);
	}

	static void findPair(int[] arr, int n, int diff) {
		Set<Integer> diffSet = new HashSet<>();

		for (int i = 0; i < n; i++) {
			if (diffSet.contains(Math.abs(arr[i] - diff))) {
				System.out.println(arr[i] + " " + Math.abs((diff - arr[i])));
				break;
			}else {
				diffSet.add(arr[i]);
			}
		}
	}
}
