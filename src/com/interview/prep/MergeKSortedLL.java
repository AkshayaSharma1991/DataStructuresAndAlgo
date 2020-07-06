/**
 * 
 */
package com.interview.prep;

import com.dsa.linkedlist.single.SinglyLinkedList;

/**
 * @author akshayas
 *
 */
public class MergeKSortedLL {

	public static void main(String[] args) {
		SinglyLinkedList[] arr1 = new SinglyLinkedList[2];
		SinglyLinkedList sll1 = new SinglyLinkedList();
		sll1.append(1);
		sll1.append(2);
		sll1.append(4);

		arr1[0] = sll1;

		SinglyLinkedList sll2 = new SinglyLinkedList();
		sll2.append(1);
		sll2.append(3);
		sll2.append(4);

		arr1[1] = sll2;

		/*
		 * SinglyLinkedList sll3 = new SinglyLinkedList(); sll3.append(23);
		 * sll3.append(34); sll3.append(93); sll3.append(2000); sll3.append(3000);
		 * 
		 * arr1[2] = sll3;
		 */

		System.out.println("Merged array is :");
		mergeKSortedArrays(arr1);
	}

	static void mergeKSortedArrays(SinglyLinkedList[] arr) {
		MinHeap mh = new MinHeap();
		int resultSize = 0;
		for (int i = 0; i < arr.length; i++) {
			HeapNode h = new HeapNode(arr[i].getHead().data, i, 1);
			mh.add(h);
			resultSize += arr[i].getSize();
		}

		int[] result = new int[resultSize];
		for (int i = 0; i < resultSize; i++) {
			HeapNode h = mh.pop();
			result[i] = h.element;
			if (h.j < arr[h.i].getSize()) {
				mh.add(new HeapNode(arr[h.i].get(h.j++), h.i, h.j++));
			} else
				mh.add(new HeapNode(Integer.MAX_VALUE, h.i, h.j++));
		}

		for (int i = 0; i < resultSize; i++) {
			System.out.print(" " + result[i]);
		}
	}
}
