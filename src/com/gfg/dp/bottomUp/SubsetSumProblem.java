/**
 * 
 */
package com.gfg.dp.bottomUp;

/**
 * @author akshayas
 *
 */
public class SubsetSumProblem {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5 };
		int n = arr.length;
		int sum = 15;
		System.out.println("Subset sum exists: " + isSubsetExists(arr, sum, n));
	}

	static boolean isSubsetExists(int[] arr, int sum, int n) {

		boolean[][] t = new boolean[n + 1][sum + 1];
		for (int i = 0; i <= 0; i++) {
			for (int j = 0; j < sum + 1; j++) {
				t[i][j] = false;
			}
		}
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j <= 0; j++) {
				t[i][j] = true;
			}
		}
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {

				if (arr[i - 1] <= j) {
					t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
				} else
					t[i][j] = t[i - 1][j];
			}

		}
		return t[n][sum];
	}

}
