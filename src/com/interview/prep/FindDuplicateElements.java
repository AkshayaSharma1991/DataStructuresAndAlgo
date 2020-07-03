/**
 * 
 */
package com.interview.prep;

/**
 * @author akshayas
 *
 */
public class FindDuplicateElements {

	public static void main(String[] args) {
		int[] a = { 1, 1, 2, 3, 2, 3, 4, 4, 5, 5 };
		int n = a.length;
		printDuplicateElements(a, n);
	}

	static void printDuplicateElements(int[] a, int n) {
		for (int i = 0; i < n; i++) {
			if (a[Math.abs(a[i])] >= 0) {
				a[Math.abs(a[i])] = -a[Math.abs(a[i])];
			} else {
				System.out.print(" " + Math.abs(a[i]));
			}
		}
	}
}
