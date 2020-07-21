/**
 * 
 */
package com.gfg.linkedlist;

import com.dsa.linkedlist.single.Node;
import com.dsa.linkedlist.single.SinglyLinkedList;

/**
 * @author akshayas
 *
 */
public class MergeSort {
	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.append(2);
		list.append(1);
		list.append(34);
		list.append(3);
		list.append(12);
		list.traverse();
		list.setHead(mergeSort(list.getHead()));
		list.traverse();
	}

	static Node mergeSort(Node node) {
		if (node == null || node.next == null)
			return node;
		Node middleNode = getMiddle(node);
		Node middleNext = middleNode.getNext();

		middleNode.setNext(null);

		Node n1 = mergeSort(node);
		Node n2 = mergeSort(middleNext);

		return sortedMerge(n1, n2);
	}

	static Node sortedMerge(Node n1, Node n2) {
		Node result = null;
		if (n1 == null && n2 == null)
			return null;
		if (n1 == null)
			return n2;
		if (n2 == null)
			return n1;
		if (n1.data < n2.data) {
			result = n1;
			result.next = sortedMerge(n1.getNext(), n2);
		} else {
			result = n2;
			result.next = sortedMerge(n1, n2.getNext());
		}
		return result;
	}

	static Node getMiddle(Node head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;

		Node fast = head, slow = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}
