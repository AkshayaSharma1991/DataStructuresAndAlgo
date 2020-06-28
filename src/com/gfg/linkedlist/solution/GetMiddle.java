/**
 * 
 */
package com.gfg.linkedlist.solution;

import com.dsa.linkedlist.single.Node;
import com.dsa.linkedlist.single.SinglyLinkedList;

/**
 * @author akshayas
 *
 */
public class GetMiddle {

	public static void main(String[] args) {
		SinglyLinkedList l1 = new SinglyLinkedList();
		l1.append(1);
		l1.append(2);
		l1.append(3);
		l1.append(4);
		l1.append(5);
		
		System.out.println(getMiddle(l1.getHead()));
	}
	public static int getMiddle(Node head) {
		Node fast = head, slow=head;
		
		while(fast!=null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return slow.data;
	}
}


