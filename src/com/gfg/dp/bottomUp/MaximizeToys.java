/**
 * 
 */
package com.gfg.dp.bottomUp;

/**
 * @author akshayas
 *
 */
public class MaximizeToys {

	public static void main(String[] args) {
		int[] price = { 1, 12, 5, 111, 200, 1000, 10 };
		System.out.println(maximizeToys(price, price.length, 50));
	}

	static int maximizeToys(int[] price, int n, int N) {
		int[][] t = new int[n + 1][N + 1];
		for (int i = 0; i < n; i++) {
			t[i][0] = 1;
		}
		for (int i = 0; i < N; i++) {
			t[0][i] = 0;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= N; j++) {
				if (price[i - 1] <= j) {
					t[i][j] = 1 + t[i - 1][j - 1];
				} else
					t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
			}
		}
		return t[n][N];
	}

}
