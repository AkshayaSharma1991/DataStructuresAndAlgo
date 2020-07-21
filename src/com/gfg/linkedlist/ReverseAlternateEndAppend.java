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
public class ReverseAlternateEndAppend {
	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.append(1);
		sll.append(2);
		sll.append(3);
		sll.append(4);
		sll.append(5);
		sll.append(6);

		sll.traverse();
		sll.setHead(performReverse(sll.getHead()));
		sll.traverse();
	}

	static Node performReverse(Node head) {
		if (head == null || head.next == null)
			return head;
		Node evenStart = head, evenEnd = head;
		Node oddStart = head.next, oddEnd = head.next;

		int count = 2;
		Node curr = oddStart.next;

		while (curr != null) {
			if (count % 2 == 0) {
				evenEnd.next = curr;
				evenEnd = evenEnd.next;
			} else {
				oddEnd.next = curr;
				oddEnd = oddEnd.next;
			}
			curr = curr.next;
			count++;
		}

		evenEnd.next = null;
		oddEnd.next = null;

		Node reversed = reverse(oddStart);
		evenEnd.next = reversed;
		return evenStart;
	}

	static Node reverse(Node n) {
		if (n == null || n.next == null)
			return n;
		Node newHead = null;
		Node prev = n;
		Node curr = n.next;

		prev.setNext(null);

		while (curr != null) {
			Node next = curr.getNext();
			curr.setNext(prev);
			newHead = curr;
			prev = curr;
			curr = next;
		}
		return newHead;

	}
}
