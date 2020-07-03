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
public class IntersectionPointOfTwoLists {

	public static void main(String[] args) {
		SinglyLinkedList sll1 = new SinglyLinkedList();
		sll1.append(1);
		sll1.append(2);
		sll1.append(12);
		sll1.append(22);
		sll1.append(32);
		sll1.append(3);
		sll1.append(4);

		SinglyLinkedList sll2 = new SinglyLinkedList();
		sll2.append(5);
		sll2.append(6);
		sll2.append(3);
		sll2.append(4);
		
		System.out.println("Intersection point: " + intersectionNode(sll1, sll2));
	}

	static int intersectionNode(SinglyLinkedList sll1, SinglyLinkedList sll2) {
		SinglyLinkedList biggerLL = null;
		SinglyLinkedList smallerLL = null;
		if (sll1.getSize() > sll2.getSize()) {
			biggerLL = sll1;
			smallerLL = sll2;
		} else {
			biggerLL = sll2;
			smallerLL = sll1;
		}

		int d = biggerLL.getSize() - smallerLL.getSize();
		return _intersectionNode(biggerLL.getHead(), smallerLL.getHead(), d);
	}

	static int _intersectionNode(Node n1, Node n2, int d) {
		for (int i = 0; i < d; i++) {
			n1 = n1.getNext();
		}

		while (n1 != null && n2 != null) {
			if (n1.data == n2.data)
				return n1.data;
			else {
				n1 = n1.getNext();
				n2 = n2.getNext();
			}
		}
		return -1;
	}
}
