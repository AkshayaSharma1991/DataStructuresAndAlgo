/**
 * 
 */
package com.gfg.divideAndConquer;

/**
 * @author akshayas
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		int arr[] = {10, 7, 8, 9, 1, 5}; 
        int n = arr.length; 
        quickSort(arr, n, 0, n-1);
        System.out.println("Success");
	}

	static void quickSort(int[] arr, int n, int low, int high) {
		if (low < high) {
			int partition = partition(arr, n, low, high);
			quickSort(arr, n, low, partition-1);
			quickSort(arr, n, partition + 1, high);
		}
	}

	static int partition(int[] arr, int n, int low, int high) {
		int pivot = arr[high];
		int i = low - 1;

		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[high];
		arr[high] = arr[i + 1];
		arr[i + 1] = temp;
		return i + 1;
	}
}
