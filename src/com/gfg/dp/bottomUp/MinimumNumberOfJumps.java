/**
 * 
 */
package com.gfg.dp.bottomUp;

/**
 * @author akshayas
 *
 */
public class MinimumNumberOfJumps {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 6, 1, 0, 9 };
		int size = arr.length;
		System.out.println("Minimum number of" + " jumps to reach end is " + minJumps(arr, size));
	}

	static int minJumps(int[] arr, int n) {
		int[] jumps = new int[n];

		if (n == 0 || arr[0] == 0)
			return Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j <= i + arr[i] && j < n; j++) {
				jumps[j] = Math.max(1 + jumps[i], jumps[j]);
			}
		}
		return jumps[n - 1];
	}

}
