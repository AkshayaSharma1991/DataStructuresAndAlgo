/**
 * 
 */
package com.gfg.divideAndConquer;

/**
 * @author akshayas
 *
 */
public class Power {

	public static void main(String[] args) {
		int x = 2;
		int y = 3;

		System.out.printf("%d", pow(x, y));
	}

	static int pow(int x, int y) {
		if (y == 0)
			return 1;
		if (y % 2 == 0) {
			int temp = pow(x, y / 2);
			return temp * temp;
		} else {
			int temp = pow(x, y / 2);
			return x * temp * temp;
		}
	}
}
