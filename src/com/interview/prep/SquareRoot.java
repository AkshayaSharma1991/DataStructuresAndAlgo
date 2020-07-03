/**
 * 
 */
package com.interview.prep;

/**
 * @author akshayas
 *
 */
public class SquareRoot {

	public static void main(String[] args) {
		System.out.println("Square root: "  + sqrt(25));
	}

	static int sqrt(int n) {
		if (n == 0 || n == 1)
			return n;
		else {
			int start = 1, end = n, ans = 0;
			while (start <= end) {
				int mid = (start + end) / 2;
				if (mid * mid == n)
					return mid;
				if (mid * mid < n) {
					start = mid + 1;
					ans = mid;
				} else {
					end = mid - 1;
				}
			}
			return ans;
		}
	}
}
