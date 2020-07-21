/**
 * 
 */
package com.gfg.dp.bottomUp;

/**
 * @author akshayas
 *
 */
public class FindSubSumCount {

	public static void main(String[] args) {
		int[] arr = { 2, 3, 5, 8, 10 };
		int sum = 10;
		int n = arr.length;
		System.out.println("Count of subsets: " + findCount(arr, n, sum));
	}

	static int findCount(int[] arr, int n, int sum) {
		int[][] t = new int[n + 1][sum + 1];
		for (int i = 0; i <= 0; i++) {
			for (int j = 0; j < sum + 1; j++) {
				t[i][j] = 0;
			}
		}
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j <= 0; j++) {
				t[i][j] = 1;
			}
		}
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {

				if (arr[i - 1] <= j) {
					t[i][j] = t[i - 1][j] + t[i - 1][j - arr[i - 1]];
				} else
					t[i][j] = t[i - 1][j];
			}
		}
		return t[n][sum];
	}
}
