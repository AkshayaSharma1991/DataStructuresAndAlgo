/**
 * 
 */
package com.gfg.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import com.dsa.linkedlist.single.Node;
import com.dsa.linkedlist.single.SinglyLinkedList;

/**
 * @author akshayas
 *
 */
public class MergeKSortedList {

	public static void main(String[] args) {
		SinglyLinkedList sll1 = new SinglyLinkedList();
		sll1.append(1);
		sll1.append(3);
		sll1.append(5);
		sll1.append(10);

		SinglyLinkedList sll2 = new SinglyLinkedList();
		sll2.append(2);
		sll2.append(4);
		sll2.append(8);
		sll2.append(9);

		SinglyLinkedList sll3 = new SinglyLinkedList();
		sll3.append(6);
		sll3.append(7);

		List<Node> nodeList = new ArrayList<>();
		nodeList.add(sll1.getHead());
		nodeList.add(sll2.getHead());
		nodeList.add(sll3.getHead());

		SinglyLinkedList mergedList = new SinglyLinkedList(mergeKLists(nodeList));
		mergedList.traverse();
	}

	static Node mergeKLists(List<Node> nodeList) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (Node head : nodeList) {
			while (head != null) {
				minHeap.add(head.data);
				head = head.next;
			}
		}
		Node head = new Node(minHeap.poll());
		Node prev = head;
		Node curr = null;

		while (minHeap.size() > 0) {
			curr = new Node(minHeap.poll());
			prev.setNext(curr);
			prev = curr;
		}
		return head;
	}
}
