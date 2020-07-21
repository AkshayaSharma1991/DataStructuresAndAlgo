/**
 * 
 */
package com.gfg.dp.bottomUp;

/**
 * @author akshayas
 *
 */
public class RodCuttingProblem {

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
		int size = arr.length;
		System.out.println("Maximum Obtainable Value is " + cutRod(arr, size));
	}

	static int cutRod(int[] price, int N) {
		int[][] t = new int[N + 1][N + 1];
		int[] length = new int[N];
		for (int i = 1; i <= N; i++) {
			length[i - 1] = i;
		}
		for (int i = 0; i < N + 1; i++) {
			for (int j = 0; j <= 0; j++) {
				t[i][j] = 0;
			}
		}

		for (int i = 0; i <= 0; i++) {
			for (int j = 0; j <= N; j++) {
				t[i][j] = 0;
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (length[i - 1] <= j) {
					t[i][j] = Math.max(t[i - 1][j], price[i - 1] + t[i][j - length[i - 1]]);
				} else
					t[i][j] = t[i - 1][j];
			}
		}

		return t[N][N];
	}
}
