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
public class RemoveLoopInLL {

	public static void main(String[] args) {
		SinglyLinkedList sll =  new SinglyLinkedList();
		sll.append(1);
		sll.append(2);
		Node n = sll.append(3);
		sll.append(4);
		Node n1 = sll.append(5);
		
		n1.setNext(n);
		detectAndRemoveLoop(sll.getHead());
		sll.traverse();
	}

	static void detectAndRemoveLoop(Node node) {
		if (node == null || node.next == null)
			return;

		Node fast = node;
		Node slow = node;

		fast = node.next.next;
		slow = node.next;

		while (fast != null && fast.getNext() != null) {
			if (fast == slow)
				break;
			slow = slow.next;
			fast = fast.next.next;
		}

		if (fast == slow) {
			slow = node;
			while (slow.next != fast.next) {
				slow = slow.next;
				fast = fast.next;
			}
			fast.setNext(null);
		}
	}
}
