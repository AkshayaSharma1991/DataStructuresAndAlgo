/**
 * 
 */
package com.interview.prep;

/**
 * @author akshayas
 *
 */
public class RainwaterTrappingProblem {

	public static void main(String[] args) {
		int arr[] = { 3, 0, 0, 2, 0, 4 };
		System.out.println("Water trapped: " + rainWaterTrapped(arr, arr.length));
	}

	static int rainWaterTrapped(int[] arr, int n) {
		int[] maxL = new int[n];
		int[] maxR = new int[n];
		int[] water = new int[n];

		maxL[0] = arr[0];
		for (int i = 1; i < n; i++) {
			maxL[i] = Math.max(maxL[i - 1], arr[i]);
		}

		maxR[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			maxR[i] = Math.max(maxR[i + 1], arr[i]);
		}

		int water_trapped = 0;
		for (int i = 0; i < n; i++) {
			water[i] = Math.min(maxL[i], maxR[i]) - arr[i];
			water_trapped += water[i];
		}

		return water_trapped;
	}
}
