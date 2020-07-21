/**
 * 
 */
package com.gfg.greedy;

import java.util.Arrays;

/**
 * @author akshayas
 *
 */
public class MaximizeToys {
	public static void main(String[] args) {
		int[] price = { 1, 12, 5, 111, 200, 1000, 10 };
		System.out.println(maximizeToys(price, price.length, 50));
	}

	static int maximizeToys(int[] price, int n, int N) {
		Arrays.sort(price);

		int currSum = N;
		int count = 0;

		for (int i = 0; i < n; i++) {
			if (price[i] <= currSum) {
				currSum = currSum - price[i];
				count++;
			} else
				break;
		}
		return count;
	}
}
