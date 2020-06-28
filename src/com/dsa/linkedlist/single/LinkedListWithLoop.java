/**
 * 
 */
package com.dsa.linkedlist.single;

/**
 * @author akshayas
 *
 */
public class LinkedListWithLoop extends SinglyLinkedList{
	
	Node loopNode = null;
	int loopIndex = 4;
	
	public Node append(int data) {
		Node newNode = super.append(data);
		if(getSize()==loopIndex) {
			loopNode = newNode;
		}
		else if(getSize()== 8) {
			newNode.setNext(loopNode);
		}
		return newNode;
	}
	
	public boolean isLoopDetected() {
		Node fast = this.getHead();
		Node slow = this.getHead();
		
		while(fast!=null && fast.getNext() !=null) {
			fast = fast.getNext().getNext();
			slow = slow.getNext();
			if(fast == slow)
				return true;
		}
		return false;
	}

	public int  detectLoopNode() {
		Node fast = this.getHead();
		Node slow = this.getHead();
		
		while(fast!=null && fast.getNext() !=null) {
			fast = fast.getNext().getNext();
			slow = slow.getNext();
			if(fast == slow) {
				Node temp = this.getHead();
				while(temp != fast) {
					temp = temp.getNext();
					fast = fast.getNext();
				}
				return temp.data;
				
			}
				
		}
		return 0;
	}
}
