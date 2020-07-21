/**
 * 
 */
package com.gfg.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author akshayas
 *
 */
public class Sort012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.valueOf(reader.readLine());
		for (int i = 1; i <= cases * 2; i += 2) {
			String s = reader.readLine();
			int arrLen = Integer.valueOf(s);

			int[] arr = new int[arrLen];
			String s1 = reader.readLine();
			String[] arrStr = s1.split(" ");
			for (int j = 0; j < arrLen; j++) {
				arr[j] = Integer.valueOf(arrStr[j]);
			}
			sort012(arr);
		}
	}

	private static void sort012(int[] arr) {
		System.out.println();
		int zero = 0;
		int one = 0;
		int two = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0)
				zero++;
			else if (arr[i] == 1)
				one++;
			else
				two++;
		}
		StringBuffer sb  = new StringBuffer();
		if (zero > 0) {
			for (int i = 0; i < zero; i++) {
				sb.append(0 +  " ");
			}
		}
		if (one > 0) {
			for (int i = 0; i < one; i++) {
				sb.append(1 +  " ");
			}
		}
		if (two > 0) {
			for (int i = 0; i < two; i++) {
				sb.append(2 +  " ");
			}
		}
		System.out.println(sb.toString());
	}
}
