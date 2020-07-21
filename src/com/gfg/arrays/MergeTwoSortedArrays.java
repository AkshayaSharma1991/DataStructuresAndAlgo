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
public class MergeTwoSortedArrays {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.valueOf(reader.readLine());
		for (int i = 1; i <= cases * 3; i += 3) {
			String s = reader.readLine();
			int a1Len = Integer.valueOf(s.split(" ")[0]);
			int a2Len = Integer.valueOf(s.split(" ")[1]);
			int[] arr1 = new int[a1Len];
			String s1 = reader.readLine();
			String[] arr1Str = s1.split(" ");
			for (int j = 0; j < a1Len; j++) {
				arr1[j] = Integer.valueOf(arr1Str[j]);
			}
			int[] arr2 = new int[a2Len];
			String s2 = reader.readLine();
			String[] arr2Str = s2.split(" ");
			for (int j = 0; j < a2Len; j++) {
				arr2[j] = Integer.valueOf(arr2Str[j]);
			}
			
			mergedSortedArrays(arr1, arr2, new int[a1Len + a2Len]);
		}
	}
	private static void mergedSortedArrays(int[] a, int[] b, int[] result) {
		int[] smallerArray = a.length > b.length ? b : a;
		int[] biggerArray = a.length < b.length ? b : a;

		int sPointer = 0, bPointer = 0;
		int resultPointer = 0;
		while (sPointer < smallerArray.length && bPointer < biggerArray.length) {
			if (smallerArray[sPointer] < biggerArray[bPointer]) {
				result[resultPointer] = smallerArray[sPointer];
				resultPointer++;
				sPointer++;
			} else {
				result[resultPointer] = biggerArray[bPointer];
				resultPointer++;
				bPointer++;
			}
		}
		for (int i = bPointer; i < biggerArray.length; i++) {
			result[resultPointer] = biggerArray[i];
			resultPointer++;
		}

		StringBuffer sb  = new StringBuffer();
		for(int i=0; i< resultPointer; i++) {
			sb.append(result[i] + " ");
		}
		System.out.println(sb.toString());
	}
}
