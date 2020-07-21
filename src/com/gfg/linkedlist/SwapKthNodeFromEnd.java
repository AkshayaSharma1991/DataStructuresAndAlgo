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
public class SwapKthNodeFromEnd {

	public static void main(String[] args) {
		SinglyLinkedList l1 = new SinglyLinkedList();
		for (int i = 1; i < 9; i++) {
			l1.append(i);
		}

		l1.traverse();
		l1.setHead(swapKthNodeFromEnd(l1, 1));
		l1.traverse();
	}

	static Node swapKthNodeFromEnd(SinglyLinkedList l, int k) {
		int n = l.getSize();
		if (n < k)
			return l.getHead();
		if (2 * n - 1 == k)
			return l.getHead();
		else {
			Node x = l.getHead();
			Node x_prev = null;

			for (int i = 1; i < k; i++) {
				x_prev = x;
				x = x.next;
			}

			Node y = l.getHead();
			Node y_prev = null;

			for (int i = 1; i < n - k + 1; i++) {
				y_prev = y;
				y = y.next;
			}

			if (x_prev != null) {
				x_prev.next = y;
			}
			if (y_prev != null) {
				y_prev.next = x;
			}

			Node temp = x.next;
			x.next = y.next;
			y.next = temp;

			if (k == 1)
				l.setHead(y);
			if (k == n)
				l.setHead(x);

			return l.getHead();
		}
	}
}
