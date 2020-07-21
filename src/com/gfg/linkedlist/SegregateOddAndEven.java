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
public class SegregateOddAndEven {
	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.append(1);
		sll.append(2);
		sll.append(3);
		sll.append(4);
		sll.append(5);

		sll.traverse();
		sll.setHead(segregateOddAndEven(sll.getHead()));
		sll.traverse();
	}

	static Node segregateOddAndEven(Node head) {
		Node evenStart = null;
		Node evenEnd = null;
		Node oddStart = null, oddEnd = null;

		Node curr = head;
		while (curr != null) {
			int element = curr.data;
			if (element % 2 == 0) {
				if (evenStart == null) {
					evenStart = curr;
					evenEnd = evenStart;
				} else {
					evenEnd.next = curr;
					evenEnd = evenEnd.next;
				}
			} else {
				if (oddStart == null) {
					oddStart = curr;
					oddEnd = oddStart;
				} else {
					oddEnd.next = curr;
					oddEnd = oddEnd.next;
				}
			}
			curr = curr.next;
		}
		if (evenStart == null || oddStart == null)
			return head;
		evenEnd.next = oddStart;
		oddEnd.next = null;
		head = evenStart;
		return head;
	}

}
