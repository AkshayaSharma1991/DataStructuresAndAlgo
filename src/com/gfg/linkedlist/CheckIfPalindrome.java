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
public class CheckIfPalindrome {

	static Node left;
	static Node head;
	public static void main(String[] args) {
		SinglyLinkedList l1 =  new SinglyLinkedList();
		l1.append(1);
		l1.append(2);
		l1.append(2);
		l1.append(1);
		l1.append(3);
		head = l1.getHead();
		left = head;
		System.out.println(isPalidrome(l1.getHead()));
	}
	
	static boolean isPalidrome(Node node) {
		if(node == null)
			return true;
		
		boolean isPalindrome = isPalidrome(node.getNext());
		if(isPalindrome) {
			if(left ==  node)
				return true;
			if(left.getData()  == node.getData()) {
				left = left.getNext();
				return true;
			}
		}
		return false;
	}
}
