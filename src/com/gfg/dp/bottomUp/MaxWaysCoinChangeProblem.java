/**
 * 
 */
package com.gfg.dp.bottomUp;

/**
 * @author akshayas
 *
 */
public class MaxWaysCoinChangeProblem {

	public static void main(String[] args) {
		int arr[] = { 2, 5, 3, 6 };
		int m = arr.length;
		System.out.println(count(arr, m, 10));
	}

	static int count(int[] coins, int n, int sum) {
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

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (coins[i - 1] <= j) {
					t[i][j] = t[i - 1][j] + t[i][j - coins[i - 1]];
				} else
					t[i][j] = t[i - 1][j];
			}
		}

		return t[n][sum];
	}
}
