/**
 * 
 */
package com.dsa.sorting;

import com.dsa.binarySearchTree.BinarySearchTree;
import com.dsa.binaryTree.BinaryTreeNode;
import com.dsa.linkedlist.single.Node;
import com.dsa.linkedlist.single.SinglyLinkedList;

/**
 * @author akshayas
 *
 */
public class SortingUtil {

	public static SinglyLinkedList sortedMergeLL(SinglyLinkedList l1, SinglyLinkedList l2) {
		SinglyLinkedList l3 = new SinglyLinkedList(sortedMerge(l1.getHead(), l2.getHead()));

		return l3;
	}

	private static Node sortedMerge(Node a, Node b) {
		if (a == null)
			return b;
		if (b == null)
			return a;

		if (a.getData() < b.getData()) {
			a.setNext(sortedMerge(a.getNext(), b));
			return a;
		} else {
			b.setNext(sortedMerge(a, b.getNext()));
			return b;
		}

	}

	public static int findMin(int[] a) {
		return findMin(a, 0, a.length - 1);
	}

	private static int findMin(int[] a, int low, int high) {
		if (low == high)
			return a[low];

		else {
			int mid = low + (high - low) / 2;

			int i = findMin(a, low, mid);
			int j = findMin(a, mid + 1, high);
			return Math.min(i, j);
		}

	}

	public static int pow(int x, int y) {
		int val = power(x, y);
		return val * val;
	}

	private static int power(int x, int y) {
		if (y == 1)
			return x;
		else
			return x * power(x, y / 2);
	}

	public static BinarySearchTree<Integer> createBST(int[] a) {
		BinarySearchTree<Integer> bst  = new BinarySearchTree<>();
		bst.root = createBST(a, 0, a.length-1);
		return bst;
	}
	private static BinaryTreeNode<Integer> createBST(int[] a, int low, int high) {
		if(low > high)
			return null;
		if (low == high) {
			BinaryTreeNode<Integer> node = new BinaryTreeNode<>();
			node.setData(a[low]);
			return node;
		} else {
			int mid = (low+high)/2;
			BinaryTreeNode<Integer> node = new BinaryTreeNode<>();
			node.setData(a[mid]);
			node.setLeft(createBST(a, low, mid - 1));
			node.setRight(createBST(a, mid + 1, high));

			return node;
		}
	}

	public static void sortZeroesAndOnes(int[] arr) {
		int l = 0;
		int r = arr.length - 1;

		while (l < r) {
			while (arr[l] == 0 && l < r)
				l++;
			while (arr[r] == 1 && l < r)
				r--;
			if (l < r) {
				swap(arr, l, r);
			}
		}
	}

	private static void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	public static int[] mergeSortedArrays(int[] a, int[] b) {
		int[] result = new int[a.length + b.length];
		mergedSortedArrays(a, b, result);
		return result;
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

	}
}
