/**
 * 
 */
package com.interview.prep;

/**
 * @author akshayas
 *
 */
public class SearchElementInSortedMatrix {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
				{ 18, 21, 23, 26, 30 } };
		
		System.out.println(searchElement(matrix, 25));
	}

	static boolean searchElement(int[][] matrix, int target) {
		int row = matrix.length;
		int col = matrix[0].length;

		int i = 0, j = row - 1;

		while (i >= 0 && i < row && j >= 0 && j < col) {
			if (matrix[i][j] == target)
				return true;
			else if (matrix[i][j] > target)
				j--;
			else
				i++;
		}
		return false;
	}
}
