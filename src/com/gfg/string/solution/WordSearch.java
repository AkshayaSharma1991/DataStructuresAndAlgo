/**
 * 
 */
package com.gfg.string.solution;

/**
 * @author akshayas
 *
 */
public class WordSearch {

	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		System.out.println("ABCCED: "  + wordSearch(board, "ABCCED"));
		System.out.println("SEE: "  + wordSearch(board, "SEE"));
		System.out.println("ABCB: "  + wordSearch(board, "ABCB"));
		
	}

	static boolean wordSearch(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word))
					return true;
			}
		}
		return false;
	}

	static boolean dfs(char[][] board, int i, int j, int count, String word) {
		if (count == word.length())
			return true;
		if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(count))
			return false;

		char temp = board[i][j];
		board[i][j] = ' ';
		boolean found = dfs(board, i - 1, j, count + 1, word) || dfs(board, i + 1, j, count + 1, word)
				|| dfs(board, i, j - 1, count + 1, word) || dfs(board, i, j + 1, count + 1, word);
		board[i][j] = temp;
		return found;
	}
}
