/**
 * 
 */
package com.gfg.dp.bottomUp;

/**
 * @author akshayas
 *
 */
public class NumberOfPaths {

	public static void main(String[] args) {
		System.out.println(pathCount(3, 3));
	}

	static int pathCount(int m, int n) {
		int[][] t = new int[m][n];
		for (int i = 0; i < m; i++) {
			t[i][0] = 1;
		}
		for (int i = 0; i < n; i++) {
			t[0][i] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				t[i][j] = t[i - 1][j] + t[i][j - 1];
			}
		}
		return t[m - 1][n - 1];
	}
}
