/**
 * 
 */
package com.dsa.linkedlist.single;

/**
 * @author akshayas
 *
 */
public class LinkedListWithLoopMain {
	public static void main(String[] args) {
		LinkedListWithLoop ll = new LinkedListWithLoop();
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(4);
		ll.append(5);
		ll.append(6);
		ll.append(7);
		ll.append(8);
		
		System.out.println("Is loop detected: " + ll.isLoopDetected());
		if(ll.isLoopDetected()) {
			System.out.println("Loop  node: " + ll.detectLoopNode());
		}
	}
}
