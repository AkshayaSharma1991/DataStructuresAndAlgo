/**
 * 
 */
package com.gfg.linkedlist;

import com.dsa.genericLinkedList.GenericLinkedList;
import com.dsa.genericLinkedList.GenericNode;

/**
 * @author akshayas
 *
 */
public class SegregateVowelsAndConsonants {
	public static void main(String[] args) {
		GenericLinkedList<Character> sll = new GenericLinkedList<>();
		sll.append('a');
		sll.append('b');
		sll.append('c');
		sll.append('d');
		sll.append('e');
		sll.append('o');
		sll.append('x');
		sll.append('i');

		sll.traverse();
		sll.setHead(segregateVowelsAndConsonants(sll.getHead()));
		sll.traverse();
	}

	static GenericNode<Character> segregateVowelsAndConsonants(GenericNode<Character> head) {
		GenericNode<Character> evenStart = null;
		GenericNode<Character> evenEnd = null;
		GenericNode<Character> oddStart = null, oddEnd = null;

		GenericNode<Character> curr = head;
		while (curr != null) {
			char element = curr.getData();
			if (element == 'a' || element == 'e' || element == 'i' || element == 'o' || element == 'u') {
				if (evenStart == null) {
					evenStart = curr;
					evenEnd = evenStart;
				} else {
					evenEnd.next = curr;
					evenEnd = evenEnd.next;
				}
			} else {
				if (oddStart == null) {
					oddStart = curr;
					oddEnd = oddStart;
				} else {
					oddEnd.next = curr;
					oddEnd = oddEnd.next;
				}
			}
			curr = curr.next;
		}
		if (evenStart == null || oddStart == null)
			return head;
		evenEnd.next = oddStart;
		oddEnd.next = null;
		head = evenStart;
		return head;
	}

}
