/**
 * 
 */
package com.interview.prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author akshayas
 *
 */
public class MovieInflight {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(20);
		list.add(70);
		list.add(90);
		list.add(30);
		list.add(60);
		list.add(110);
		PairInt ids = IDsOfmovies(110, 6, list);
		System.out.println(ids);
	}

	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	static PairInt IDsOfmovies(int flightDuration, int numMovies, ArrayList<Integer> movieDuration) {
		// Initialize for the edge case
		PairInt result = new PairInt(-1, -1);

		// target reset to match the movie end time
		int target = flightDuration - 30;

		// Largest initialized to track movie with longest runtime
		int longestMovieRuntime = Integer.MIN_VALUE;

		Map<Integer, Integer> diffMap = new HashMap<>();

		// Iterate through the movieDuration array and set the
		// longestMovieRuntime and calculate the exact difference
		for (int i = 0; i < numMovies; i++) {
			int currVal = movieDuration.get(i);
			int diff = Math.abs(currVal - (target - currVal));
			if (diffMap.containsKey(currVal) && diff > longestMovieRuntime) {
				longestMovieRuntime = diff;
				result = new PairInt(diffMap.get(currVal), i);
			} else {
				diffMap.put(target - currVal, i);
			}
		}
		return result;
	}
	// METHOD SIGNATURE ENDS
}

class PairInt {
	int first;
	int second;

	public PairInt(int first, int second) {
		this.first = first;
		this.second = second;
	}
}
