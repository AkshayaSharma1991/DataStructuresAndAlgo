/**
 * 
 */
package com.gfg.dp.bottomUp;

/**
 * @author akshayas
 *
 */
public class PathWithMaxScore {

	public static void main(String[] args) {
		int[][] grid5 = new int[][] { { 20, 20, 3 }, { 20, 3, 20 }, { 3, 20, 20 } };
		System.out.println("grid5: Expected: 3, Actual: " + maxScore(grid5));
	}

	static int maxScore(int[][] grid) {
		int r = grid.length, c = grid[0].length;
		int[][] t = new int[r][c];
		t[0][0] = Integer.MAX_VALUE;
		for (int i = 1; i < r; i++) {
			t[i][0] = Math.min(t[i - 1][0], grid[i][0]);
		}
		for (int j = 1; j < c; j++)
			t[0][j] = Math.min(t[0][j - 1], grid[0][j]);

		for (int i = 1; i < r; ++i) {
			for (int j =1; j < c; ++j) {
				if (i == r - 1 && j == c - 1) {
					t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
				} else {
					int score1 = Math.min(t[i - 1][j], grid[i][j]);
					int score2 = Math.min(t[i][j - 1], grid[i][j]);
					t[i][j] = Math.max(score1, score2);
				}
			}
		}
		return t[r - 1][c - 1];
	}
}
