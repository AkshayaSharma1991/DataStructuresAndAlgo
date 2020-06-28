/**
 * 
 */
package com.dsa.doublylinkedlist;

/**
 * @author akshayas
 *
 */
public class DoublyLinkedListMain {
	
	public static void main(String[] args) {
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
		dll.append(1);
		dll.append(2);
		dll.append(3);
		dll.append(4);
		
		dll.traverse();
		System.out.println();
		dll.delete(2);
		dll.printReverse();
	}

}
