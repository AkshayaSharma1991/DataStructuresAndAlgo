/**
 * 
 */
package com.gfg.dp.bottomUp;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author akshayas
 *
 */
public class MinimumDifferenceOfSubset {

	public static void main(String[] args) {
		int[] a = { 1, 2, 7 };
		System.out.println("Minimum difference:" + minimumDifference(a, a.length));
	}

	static int minimumDifference(int[] arr, int n) {
		int range = 0;
		for (int i = 0; i < n; i++) {
			range = range + arr[i];
		}

		boolean[][] t = new boolean[n + 1][range + 1];
		for (int i = 0; i <= 0; i++) {
			for (int j = 0; j < range + 1; j++) {
				t[i][j] = false;
			}
		}
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j <= 0; j++) {
				t[i][j] = true;
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= range; j++) {
				if (i == 0)
					t[i][j] = false;
				else if (j == 0)
					t[i][j] = true;
				else {
					if (arr[i - 1] <= j) {
						t[i][j] = t[i - 1][j] || t[i - 1][j - arr[i - 1]];
					} else
						t[i][j] = t[i - 1][j];
				}
			}
		}

		List<Integer> allowedSum = new ArrayList<>();
		for (int i = n; i <= n; i++) {
			for (int j = 0; j <= range/2; j++) {
				if (t[i][j])
					allowedSum.add(j);
			}
		}

		int minDiff =  Integer.MAX_VALUE;
		
		for(int i=0; i<allowedSum.size();i++) {
			minDiff = Math.min(minDiff, (range-2*allowedSum.get(i)));
		}
		return minDiff;
	}
}
