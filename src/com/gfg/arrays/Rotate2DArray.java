/**
 * 
 */
package com.gfg.arrays;

/**
 * @author akshayas
 *
 */
public class Rotate2DArray {

	public static void main(String[] args) {
		int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		rotate2DArray(arr, 4);
		printMatrix(arr, 4);
	}

	static void rotate2DArray(int[][] arr, int n) {
		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - i - 1; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[n - 1 - j][i];
				arr[n - 1 - j][i] = arr[n - 1 - i][n - 1 - j];
				arr[n - 1 - i][n - 1 - j] = arr[j][n - 1 - i];
				arr[j][n - 1 - i] = temp;
			}
		}
	}

	// Function for print matrix
	static void printMatrix(int arr[][], int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}

}
