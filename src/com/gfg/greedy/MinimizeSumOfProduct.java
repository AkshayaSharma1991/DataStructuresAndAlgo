/**
 * 
 */
package com.gfg.greedy;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author akshayas
 *
 */
public class MinimizeSumOfProduct {

	public static void main(String[] args) {
		Integer[] a = { 6,1,9,5,4 };
		Integer[] b = { 3,4,8,2,4 };
		System.out.println(minimizeSum(a, b, a.length));
	}

	static int minimizeSum(Integer[] a, Integer[] b, int n) {
		Arrays.sort(a);
		Arrays.sort(b, Collections.reverseOrder());

		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += a[i] * b[i];
		}
		return sum;
	}
}
