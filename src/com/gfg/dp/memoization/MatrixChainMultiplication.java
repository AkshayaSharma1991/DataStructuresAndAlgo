/**
 * 
 */
package com.gfg.dp.memoization;

import java.util.Arrays;

/**
 * @author akshayas
 *
 */
public class MatrixChainMultiplication {

	public static int[][] t = new int[1001][1001];

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 30 };
		for (int[] row : t) {
			Arrays.fill(row, -1);
		}
		System.out.println(solve(arr, 1, arr.length - 1));
	}

	static int solve(int[] arr, int i, int j) {
		if (i >= j)
			return 0;
		if (t[i][j] != -1)
			return t[i][j];
		int min = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int temp = solve(arr, i, k) + solve(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
			if (temp < min)
				min = temp;
		}
		t[i][j] = min;
		return min;
	}
}
