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
public class MergeTwoListsInAlternate {
	
	public static void main(String[] args) {
		SinglyLinkedList l1= new SinglyLinkedList();
		l1.append(1);
		l1.append(3);
		l1.append(5);
		l1.append(7);
		l1.append(9);
		l1.append(11);
		
		SinglyLinkedList l2 = new SinglyLinkedList();
		l2.append(2);
		l2.append(4);
		l2.append(6);
		l2.append(8);
		l2.append(12);
		SinglyLinkedList l3 = new SinglyLinkedList(mergeAlternate(l1.getHead(), l2.getHead()));
		l3.traverse();
	}
	
	static Node mergeAlternate(Node n1, Node n2) {
		Node temp1 = n1;
		Node temp2 = n2;
		
		while(temp1!=null && temp2!=null) {
			Node temp1Next = temp1.getNext();
			temp1.setNext(temp2);
			temp1 = temp2;
			temp2 = temp1Next;
		}
	
		
		return n1;
	}

}
