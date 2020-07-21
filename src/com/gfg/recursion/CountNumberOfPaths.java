/**
 * 
 */
package com.gfg.recursion;

/**
 * @author akshayas
 *
 */
public class CountNumberOfPaths {

	public static void main(String[] args) {
		System.out.println(numberOfPaths(2, 8));
	}

	static int numberOfPaths(int m, int n) {
		if (m == 1 || n == 1) {
			return 1;
		}
		return numberOfPaths(m - 1, n) + numberOfPaths(m, n - 1);
	}
}
