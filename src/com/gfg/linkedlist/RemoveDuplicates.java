/**
 * 
 */
package com.gfg.linkedlist;

import java.util.HashSet;

import com.dsa.linkedlist.single.Node;
import com.dsa.linkedlist.single.SinglyLinkedList;

/**
 * @author akshayas
 *
 */
public class RemoveDuplicates {

	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.append(1);
		sll.append(2);
		sll.append(3);
		sll.append(2);
		sll.append(1);

		sll.traverse();
		sll.setHead(removeDuplicates(sll.getHead()));
		sll.traverse();
	}

	static Node removeDuplicates(Node head) {
		HashSet<Integer> hs = new HashSet<>();
		Node prev = head;
		Node curr = head.next;
		hs.add(head.data);
		while (prev != null && curr != null) {
			if(hs.contains(curr.data)) {
				prev.next = curr.next;
			} else {
				hs.add(curr.data);
				prev = curr;
			}
			curr = curr.next;	
		}
		
		return head;
	}
}
