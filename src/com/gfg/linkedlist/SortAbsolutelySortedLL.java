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
public class SortAbsolutelySortedLL {
	public static void main(String[] args) {
		SinglyLinkedList llist = new SinglyLinkedList(); 
        
        /* Constructed Linked List is 1->2->3->4->5->6-> 
           7->8->8->9->null */
        llist.append(-5); 
        llist.append(5); 
        llist.append(4); 
        llist.append(3); 
        llist.append(-2); 
        llist.append(1); 
        llist.append(0); 
        
        llist.traverse();
        llist.setHead(sortLL(llist.getHead()));
        llist.traverse();
	}
	
	static Node sortLL(Node head) {
		Node prev = head;
		Node curr = head.next;
		
		while(curr != null) {
			if(curr.data < prev.data) {
					prev.next = curr.next;
					curr.next = head;
					head =  curr;
					prev = curr;
					curr = curr.next;
			} else {
				prev  = curr;
				curr = curr.next;
			}
		}
		return head;
	}
}
