/**
 * 
 */
package com.gfg.divideAndConquer;

/**
 * @author akshayas
 *
 */
public class MergeSort {

	public static void main(String[] args) {
		int arr[] = { 10, 7, 8, 9, 1, 5 };
		int n = arr.length;
		mergeSort(arr, 0, n - 1);
		System.out.println("Success");
	}

	static void merge(int[] arr, int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;

		int[] L = new int[n1];
		int[] R = new int[n2];

		for (int i = 0; i < n1; i++) {
			L[i] = arr[l + i];
		}
		for (int i = 0; i < n2; i++) {
			R[i] = arr[m + 1 + i];
		}
		int i = 0, j = 0;
		int k = l;

		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	static void mergeSort(int[] arr, int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;

			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);

			merge(arr, low, mid, high);
		}
	}
}
