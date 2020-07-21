/**
 * 
 */
package com.gfg.slidingwindow;

import java.util.LinkedList;

/**
 * @author akshayas
 *
 */
public class FirstNegativeInteger {

	public static void main(String[] args) {
		int arr[] = { 12, -1, -7, 8, -15, 30, 16, 28 };

		int k = 3;
		firstNegativeInteger(arr, k);
	}

	static void firstNegativeInteger(int[] arr, int k) {
		LinkedList<Integer> Di = new LinkedList<>();
		int i;
		for (i = 0; i < k; i++) {
			if (arr[i] < 0)
				Di.add(i);
		}

		for (; i < arr.length; i++) {
			if (!Di.isEmpty())
				System.out.print(arr[Di.peek()] + "  ");
			else
				System.out.print("0 ");

			while (!Di.isEmpty() && Di.peek() < i - k + 1) {
				Di.remove();
			}

			if (arr[i] < 0)
				Di.add(i);
		}
		if (!Di.isEmpty())
			System.out.print(Di.pop());
		else
			System.out.print("0");
	}

}
