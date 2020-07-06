/**
 * 
 */
package com.interview.prep;

/**
 * @author akshayas
 *
 */
public class NumberOfIslands {

	public static final int R = 4;
	public static final int C = 5;

	public static void main(String[] args) {
		int[][] arr = { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 0, 1, 1 } };
		System.out.println(numberOfIslands(arr));
	}

	static int numberOfIslands(int[][] arr) {
		int islands = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] == 1) {
					++islands;
					markTerritory(arr, i, j);
				}
			}
		}
		return islands;
	}

	static void markTerritory(int[][] arr, int x, int y) {
		arr[x][y] = 2;
		if (isValid(x - 1, y)) {
			if (arr[x - 1][y] == 1)
				markTerritory(arr, x - 1, y);
		}
		if (isValid(x + 1, y)) {
			if (arr[x + 1][y] == 1)
				markTerritory(arr, x + 1, y);
		}
		if (isValid(x, y - 1)) {
			if (arr[x][y - 1] == 1)
				markTerritory(arr, x, y - 1);
		}
		if (isValid(x, y + 1)) {
			if (arr[x][y + 1] == 1)
				markTerritory(arr, x, y + 1);
		}
	}

	static boolean isValid(int x, int y) {
		return (x >= 0 && y >= 0 && x < R && y < C);
	}

}
