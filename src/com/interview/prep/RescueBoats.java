/**
 * 
 */
package com.interview.prep;

import java.util.Arrays;

/**
 * @author akshayas
 *
 */
public class RescueBoats {

	public static void main(String[] args) {
		int people[] = { 3, 2, 2, 1 }, limit = 3;
		System.out.println(numOfBoats(people, limit));
	}

	static int numOfBoats(int[] people, int limit) {
		int n = people.length;
		int numBoats = 0;
		Arrays.sort(people);

		int i = 0, j = n - 1;
		while (i <= j) {
			if (people[i] + people[j] <= limit) {
				i++;
				j--;
			} else {
				j--;
			}
			numBoats++;
		}
		return numBoats;
	}
}
