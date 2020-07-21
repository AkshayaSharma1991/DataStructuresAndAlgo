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
public class InsertAscendCLL {

	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.setHead(insertAscend(sll.getHead(),2));
		sll.setHead(insertAscend(sll.getHead(),4));
		sll.setHead(insertAscend(sll.getHead(),3));
		sll.setHead(insertAscend(sll.getHead(),5));
		sll.setHead(insertAscend(sll.getHead(),1));
		
		System.out.println(sll);
	}
	
	static Node insertAscend(Node head, int data) {
		Node node = new Node(data);
		if(head == null) {
			node.next = node;
			return node;
		}
		
		if(head.data>=data) {
			Node curr = head;
			while(curr.next != head) {
				curr = curr.next;
			}
			curr.next = node;
			node.next = head;
			head = node;
			return node;
		} 
		Node curr = head;
		while(curr.next != head) {
			if(curr.next.data > data)
				break;
			curr = curr.next;
		}
		Node temp = curr.next;
		curr.next = node;
		node.next = temp;
		return head;
	}
}
