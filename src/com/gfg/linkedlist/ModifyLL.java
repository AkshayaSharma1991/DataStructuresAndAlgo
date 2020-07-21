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
public class ModifyLL {

	public static void main(String[] args) {
		SinglyLinkedList l1 = new SinglyLinkedList();
		l1.append(2);
		l1.append(9);
		l1.append(8);
		l1.append(12);
		l1.append(7);
		l1.append(10);

		l1.traverse();
		l1.setHead(modifyList(l1.getHead()));
		l1.traverse();
	}

	static Node modifyList(Node head) {
		Node middle = getMiddle(head);
		Node middleNext = middle.getNext();
		middle.next = null;

		Node reversed = reverse(middleNext);

		Node curr = head;
		Node revCurr = reversed;
		while (curr != null && revCurr != null) {
			int element = curr.data;
			curr.data = revCurr.data - element;
			curr = curr.next;
			revCurr = revCurr.next;
		}

		middle.next = reverse(reversed);
		return head;
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
