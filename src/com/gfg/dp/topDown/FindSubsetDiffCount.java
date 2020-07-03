/**
 * 
 */
package com.gfg.dp.topDown;

/**
 * @author akshayas
 *
 */
public class FindSubsetDiffCount {

	public static void main(String[] args) {
		int[] arr = { 1, 1, 2, 3 };
		int diff = 1;
		System.out.println("Count: " + diffSubsetCount(arr, arr.length, diff));
	}

	static int diffSubsetCount(int[] a, int n, int diff) {
		int totalSum = 0;
		for (int i = 0; i < n; i++) {
			totalSum = totalSum + a[i];
		}

		int subsetSum = (diff + totalSum) / 2;

		int[][] t = new int[n + 1][subsetSum + 1];
		for (int i = 0; i <= 0; i++) {
			for (int j = 0; j <= subsetSum; j++) {
				t[i][j] = 0;
			}
		}

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= 0; j++) {
				t[i][j] = 1;
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= subsetSum; j++) {
				if (a[i - 1] <= j) {
					t[i][j] = t[i - 1][j] + t[i - 1][j - a[i - 1]];
				} else
					t[i][j] = t[i - 1][j];
			}
		}

		return t[n][subsetSum];
	}
}
