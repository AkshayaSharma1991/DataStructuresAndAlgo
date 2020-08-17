/**
 * 
 */
package com.gfg.string.solution;

/**
 * @author akshayas
 *
 */
public class WordSearchII {

	static int[] x = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] y = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) {
		char[][] grid = { { 'G', 'E', 'E', 'K', 'S', 'F', 'O', 'R', 'G', 'E', 'E', 'K', 'S' },
				{ 'G', 'E', 'E', 'K', 'S', 'Q', 'U', 'I', 'Z', 'G', 'E', 'E', 'K' },
				{ 'I', 'D', 'E', 'Q', 'A', 'P', 'R', 'A', 'C', 'T', 'I', 'C', 'E' } };
		patternSearch(grid, "GEEKS");
		System.out.println();
		patternSearch(grid, "EEE");
	}

	static void patternSearch(char[][] board, String word) {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				if (search(board, row, col, word)) {
					System.out.println("pattern found at " + row + ", " + col);
				}
			}
		}
	}

	static boolean search(char[][] board, int row, int col, String word) {
		if (board[row][col] != word.charAt(0))
			return false;
		int len = word.length();

		for (int dir = 0; dir < 8; dir++) {
			int k, rd = row + x[dir], cd = col + y[dir];

			for (k = 1; k < len; k++) {
				if (rd < 0 || rd >= board.length || cd < 0 || cd >= board[0].length)
					break;
				if (board[rd][cd] != word.charAt(k))
					break;
				rd += x[dir];
				cd += y[dir];
			}

			if (k == len)
				return true;
		}
		return false;
	}
}
