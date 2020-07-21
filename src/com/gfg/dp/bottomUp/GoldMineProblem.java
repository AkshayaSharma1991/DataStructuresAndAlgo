/**
 * 
 */
package com.gfg.dp.bottomUp;

import java.util.Arrays;

/**
 * @author akshayas
 *
 */
public class GoldMineProblem {

	public static void main(String[] args) {
		int gold[][] = { { 1, 3, 1, 5 }, { 2, 2, 4, 1 }, { 5, 0, 2, 3 }, { 0, 6, 1, 2 } };

		int m = 4, n = 4;

		System.out.print(maxGold(gold, m, n));
	}

	static int maxGold(int[][] gold, int m, int n) {
		int[][] goldTable = new int[m][n];

		for (int[] rows : goldTable) {
			Arrays.fill(rows, 0);
		}

		for (int col = n - 1; col >= 0; col--) {
			for (int row = 0; row < m; row++) {
				int right = (col == n - 1) ? 0 : goldTable[row][col + 1];
				int rightUp = (row == 0 || col == n - 1) ? 0 : goldTable[row - 1][col + 1];
				int rightDown = (row == m - 1 || col == n - 1) ? 0 : goldTable[row + 1][col + 1];

				goldTable[row][col] = gold[row][col] + Math.max(right, Math.max(rightUp, rightDown));
			}
		}

		int res = goldTable[0][0];
		for (int i = 1; i < m; i++) {
			res = Math.max(res, goldTable[i][0]);
		}
		return res;
	}
}
