/**
 * 
 */
package com.gfg.dp.memoization;

/**
 * @author akshayas
 *
 */
public class StepsToNStairs {
	static int[] t;

	public static void main(String[] args) {
		int n = 4;
		t = new int[n+1];
		t[0] = 1;
		t[1] = 1;
		System.out.println(countWays(4));
	}

	static int countWays(int n) {
		if (n< 0)
			return 0;
		if (t[n] != 0) {
			return t[n];
		}

		for (int i = n; i > 0; i--) {
			t[i] = countWays(i - 1) + countWays(i - 2);
		}

		return t[n];
	}
}
