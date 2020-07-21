/**
 * 
 */
package com.gfg.dp.bottomUp;

/**
 * @author akshayas
 *
 */
public class OptimalGame {

	public static void main(String[] args) {
		 int arr1[] = { 8, 15, 3, 7 }; 
	        int n = arr1.length; 
	        System.out.println( 
	            ""
	            + maxScore(arr1, n)); 
	}

	static int maxScore(int[] coins, int n) {
		int[][] t = new int[n][n];
		int gap, i, j, x, y, z = 0;

		for (gap = 0; gap < n; ++gap) {
			for (i = 0, j = gap; j < n; ++i, ++j) {
				x = ((i + 2) <= j ? t[i + 2][j] : 0);
				y = ((i + 1) <= (j - 1) ? t[i + 1][j - 1] : 0);
				z = (i <= (j - 2) ? t[i][j - 2] : 0);

				t[i][j] = Math.max(coins[i] + Math.min(x, y), coins[j] + Math.min(y, z));
			}
		}

		return t[0][n - 1];
	}
}
