/**
 * 
 */
package com.dsa.sorting;

import java.util.Arrays;

import com.dsa.binarySearchTree.BinarySearchTree;
import com.dsa.linkedlist.single.SinglyLinkedList;

/**
 * @author akshayas
 *
 */
public class SortingTest {

	public static void main(String[]  a) {
		int[] arr  = new int[]{1,48,43,7,6,3,2};
		BubbleSort.sort(arr);
		System.out.println("BubbleSort: " + Arrays.toString(arr));
		
		int[] arr1  = new int[]{1,48,43,7,6,3,2};
		InsertionSort.sort(arr1);
		System.out.println("InsertionSort: " + Arrays.toString(arr1));
		
		SinglyLinkedList l1 = new SinglyLinkedList();
		l1.append(1);
		l1.append(3);
		l1.append(5);
		
		SinglyLinkedList l2 = new SinglyLinkedList();
		l2.append(2);
		l2.append(4);
		l2.append(6);
		l2.append(8);
		System.out.println("Min  value: "  +  SortingUtil.findMin(new int[] {3,2,67,1,7}));
		SinglyLinkedList l3  = SortingUtil.sortedMergeLL(l1, l2);
		l3.traverse();
		
		
		System.out.println("pow(5,2) = " +SortingUtil.pow(5, 2));
		
		int[] intArr = new int[] {1,0,0,1,1,1,0,0};
		SortingUtil.sortZeroesAndOnes(intArr);
		System.out.println("Sorted array:"+Arrays.toString(intArr));
		
		int[] a1  = new int[] {1,3,5,7};
		int[] a2  = new int[] {2,4,6,8,10,12,13,14};
		System.out.println("Sorted array: " + Arrays.toString(SortingUtil.mergeSortedArrays(a1, a2)));
		
		BinarySearchTree<Integer> bst = SortingUtil.createBST(a2);
		System.out.println(bst.size);
	}
}
