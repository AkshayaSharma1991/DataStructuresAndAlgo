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
public class ReverseLLInGroupsOfK {

	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.append(1);
		sll.append(2);
		sll.append(3);
		sll.append(4);
		sll.append(5);
		
		sll.traverse();
		
		sll.setHead(reverseInGroupsOfK(sll.getHead(), 2));
		sll.traverse();
	}
	
	static Node reverseInGroupsOfK(Node n, int k) {
		if(n == null)
			return null;
		Node current = n;
		Node prev = null;
		Node next = null;
		
		int count = 0;
		
		while(count<k && current!=null) {
			next = current.getNext();
			current.setNext(prev);
			prev=current;
			current = next;
			count++;
		}
			
		if(next !=null)
			n.setNext(reverseInGroupsOfK(next, k));

		return prev;
			
	}
}
