/**
 * 
 */
package com.gfg.linkedlist;

import com.dsa.linkedlist.single.Node;
import com.dsa.linkedlist.single.NodeSum;
import com.dsa.linkedlist.single.SinglyLinkedList;

/**
 * @author akshayas
 *
 */
public class Add1ToNumber {

	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.append(9);
		sll.append(9);
		sll.append(9);
		sll.append(9);
		
		sll.traverse();
		sll.setHead(add1ToNumber(sll.getHead()));
		sll.traverse();
	}
	
	static Node add1ToNumber(Node head) {
		NodeSum ns = addHelper(head);
		if(ns.carry>0) {
			Node n = new Node(ns.carry);
			n.setNext(ns.node);
			return n;
		}
		return addHelper(head).node;
	}
	
	static NodeSum addHelper(Node n) {
		if(n.next == null) {
			n.data = n.data +1;
			int carry = n.data/10;
			n.data = n.data%10;
			NodeSum ns = new NodeSum(carry, n);
			return  ns;
		}
		
		NodeSum ns =  addHelper(n.next);
		n.data = n.data + ns.carry;
		int carry = n.data/10;
		n.data = n.data%10;
		NodeSum newNs = new NodeSum(carry, n);
		return  newNs;
	}
}
