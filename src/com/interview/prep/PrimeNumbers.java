/**
 * 
 */
package com.interview.prep;

/**
 * @author akshayas
 *
 */
public class PrimeNumbers {

	public static void main(String[] args) {
		int i = 1;
		int j = 20;

		printPrime(i, j);
	}

	static void printPrime(int a, int b) {
		for (int i = a; i <= b; i++) {
			if (i == 0 || i == 1)
				continue;
			int flag = 1;
			for (int j = 2; j <= i / 2; ++j) {
				if (i % j == 0) {
					flag = 0;
					break;
				}
			}
			if (flag == 1)
				System.out.print(" " + i);
		}
	}
}
