package com.dsa.linkedlist.single;

public class SinglyLinkedList {

	private int size = 0;
	private Node head;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public void append(int data) {
		// Create a new node
		Node n = new Node(data);
		// Check if this is first node
		if (null == head) {
			// Assign new node to head and increment the size
			head = n;
			size++;
			return;
		}

		else {
			// Else, create a temp node and assign head to the temp node
			Node temp = head;
			// Iterate through all nodes in linked list, till temp.getNext is null
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			// Assign new node to the temp.next() and increment the size
			temp.setNext(n);
			size++;
			return;
		}
	}

	public void traverse() {
		// Create a temp node and assign head to the temp node
		Node temp = head;
		// Iterate through all nodes till temp is not null
		while (temp != null) {
			System.out.print(" " + temp.getData());
			temp = temp.getNext();
		}
		System.out.println();
	}

	public void delete(int data) {
		/**
		 * Handle corner cases 
		 * 1. List is empty 
		 * 2. If the node to be deleted is the first node 
		 * 3. If node to be deleted is any other node other than first node
		 * 4. Data not found
		 */
		// List is empty
		if (head == null) {
			System.out.println("Linked list is empty");
			return;
		}
		// If node to be deleted is the first node
		else if (head.getData() == data) {
			//Create temp node
			Node temp = head;
			head = head.getNext();
			temp.setNext(null);
			size--;
			return;
		}
		// Delete any other node
		else {
			Node prev = head;
			Node curr = head.getNext();
			
			// Traverse on reference
			while(curr != null) {
				if(curr.getData() == data) {
					prev.setNext(curr.getNext());
					curr.setNext(null);
					size--;
					return;
				}
				else {
					prev = curr;
					curr = curr.getNext();
				}
			}
			System.out.println(String.format("%s is not found in Linked list", data));
		}
	}
	
	public int getMiddle() {
		int returnData = 0;
		Node fast = head;
		Node slow  = head;
		
		boolean  middle = false;
		
		while(!middle) {
			if(fast == null) {
				middle = true;
				returnData =  slow.getData();
			}
			else if(fast.getNext() == null) {
				middle = true;
				returnData = slow.getData();
			}
			else {
				fast = fast.getNext().getNext();
				slow = slow.getNext();
			}
				
		}
		return returnData;
	}
	
	public int getKthElementFromLast(int kIndex) {
		/**
		 * Handle the below cases
		 * 1. List is empty
		 * 2. kth index is greater than size
		 * 3. Else create 2 references
		 * 		a) Reference currentK and diffK pointing to head
		 * 		b) Move diffK to a to kIndex from head
		 * 		c) Now the difference in index between currentK and diffK is kIndex
		 * 		d) Now move currentK and diffK by one index each till diffK reaches diffK.getNext() is null
		 * 		e) Now currentK is exactly at kIndex from the last.  Return the data in currentK.
		 */
		
		// List is empty
		if(head ==  null)
			System.out.println("Linked list is empty");
		// kth index is greater than size
		else if(kIndex >= size)
			System.out.println("Index " + kIndex + " is greater than the list size");	
		
		else {
			// Reference currentK and diffK pointing to head
			Node currentK = head;
			Node diffK = head;
			
			int i =0;
			// Move diffK to a to kIndex from head.  
			// Now the difference in index between currentK and diffK is kInde
			while(i < kIndex) {
				diffK = diffK.getNext();
				i++;
			}
			
			// Now move currentK and diffK by one index 
			// each till diffK reaches diffK.getNext() is null
			while(diffK != null) {
				diffK = diffK.getNext();
				currentK = currentK.getNext();
			}
			return currentK.getData();
		}
		
		return 0;
	}
	
	public boolean isListSizeEven() {
		/**
		 * Handle the below cases
		 * 		1. List is empty
		 * 		2. If head is only node in the list: return odd
		 * 		3. Else, move the current node  by  two indices
		 * 		4. Move till you reach currentNode is null, return true
		 * 		5. Move till you reach currentNode.getNext is null, return false
		 */

		if(head ==  null)
			System.out.println("Linked list is empty.");
		
		else if(head.getNext()  ==  null)
			return false;
		else {
			Node currentNode = head;
			
			while(currentNode != null &&  currentNode.getNext() != null) {
				currentNode = currentNode.getNext().getNext();
			}
			
			if(currentNode == null)
				return true;
			else
				return false;
		}
		return false;
	}
	
	/**
	 * Printing reverse using recursion.
	 * User need not pass a node in the method call.
	 * Create a  private method that accepts the head node
	 * and recursively calls itself by passing node
	 * next to it.
	 */
	public void printReverse() {
		reverse(head);
	}
	
	private void reverse(Node node) {
		if(node == null)
			return;
		else {
			reverse(node.getNext());
			System.out.println(node.getData());
		}
	}
}
