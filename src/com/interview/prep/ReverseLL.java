/**
 * 
 */
package com.interview.prep;

import com.dsa.linkedlist.single.Node;
import com.dsa.linkedlist.single.SinglyLinkedList;

/**
 * @author akshayas
 *
 */
public class ReverseLL {

	public static void main(String[] args) {
		SinglyLinkedList l1 = new SinglyLinkedList();
		l1.append(7);
		l1.append(19);
		l1.append(9);
		l1.append(8);

		l1.traverse();
		reverseLL(l1);
		l1.traverse();
	}

	static void reverseLL(SinglyLinkedList l) {
		Node node = l.getHead();
		if (node == null)
			return;
		else if (node.getNext() == null)
			return;
		else {
			Node previous = node;
			Node current = node.next;
			Node next = node.next.next;

			if (next == null) {
				l.setHead(current);
				current.setNext(previous);
				previous.setNext(null);
				return;
			} else {
				previous.setNext(null);
				while (current != null) {
					current.setNext(previous);
					l.setHead(current);
					previous = current;
					current = next;
					if (next != null)
						next = next.getNext();
				}

			}
		}
	}
}
