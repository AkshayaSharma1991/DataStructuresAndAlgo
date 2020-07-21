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
public class RearrangeLL {
	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.append(1);
		sll.append(2);
		sll.append(3);
		sll.append(4);
		sll.append(5);
		
		sll.traverse();
		sll.setHead(rearrangeLL(sll.getHead()));
		sll.traverse();
	}
	
	static Node rearrangeLL(Node head) {
		Node middle = getMiddle(head);
		Node middleNext = middle.next;
		
		middle.next =  null;
		SinglyLinkedList l1 = new SinglyLinkedList(head);
		SinglyLinkedList l2 = new SinglyLinkedList(reverse(middleNext));
		
		Node n1 = l1.getHead();
		Node n2 = l2.getHead();
		while(n1!=null && n2!=null) {
			Node next = n1.getNext();
			n1.setNext(n2);
			Node temp  = n2;
			n2 = next;
			n1 = temp;
		}
		return  l1.getHead();
	}
	
	static Node reverse(Node n) {
		if(n == null || n.next == null)
			return n;
		Node newHead = null;
		Node prev = n;
		Node curr = n.next;
		
		prev.setNext(null);
		
		while(curr!=null) {
			Node next = curr.getNext();
			curr.setNext(prev);
			newHead = curr;
			prev = curr;
			curr = next;
		}
		return newHead;
		
	}
	static Node getMiddle(Node n) {
		if(n == null || n.next == null)
			return n;
		Node slow= n,  fast  = n;
		while(fast.next!=null &&fast.next.next!=null) {
			slow= slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}
