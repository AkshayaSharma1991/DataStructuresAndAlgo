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
public class MultiplyTwoLists {

	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.append(3);
		sll.append(2);
		sll.append(1);

		SinglyLinkedList sll1 = new SinglyLinkedList();
		sll1.append(1);
		sll1.append(2);

		System.out.println(multiply(sll.getHead(), sll1.getHead()));
	}

	static long multiply(Node n1, Node n2) {
		int num1 = 0, num2 = 0;
		while (n1 != null || n2 != null) {
			if (n1 != null) {
				num1 = num1 * 10 + n1.data;
				n1 = n1.next;
			}
			if (n2 != null) {
				num2 = num2 * 10 + n2.data;
				n2 = n2.next;
			}
		}
		return num1 * num2;
	}

}
