package com.dsa.linkedlist.single;

public class SinglyLinkedList {

	private int size = 0;
	private Node head;

	public SinglyLinkedList() {
		
	}
	public SinglyLinkedList(Node head) {
		this.head = head;
	}
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

	public Node append(int data) {
		// Create a new node
		Node n = new Node(data);
		// Check if this is first node
		if (null == head) {
			// Assign new node to head and increment the size
			head = n;
			size++;
			return n;
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
			return n;
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

	public int get(int index) {
		if(index  == 0)
			return  head.data;
		else {
			int i = 1;
			Node n = head;
			while(i<=index) {
				n  = n.next;
				i++;
			}
			return n.data;
		}
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
		reverseInternal(head);
	}
	
	private void reverseInternal(Node node) {
		if(node == null)
			return;
		else {
			reverseInternal(node.getNext());
			System.out.println(node.getData());
		}
	}
	
	/**
	 * Handle the following conditions
	 * 	1. List is empty
	 * 	2. List has one node
	 * 	3. Otherwise, create three references
	 * 			a) previous - at head
	 * 			b) current - head.getNext()
	 * 			c) next - head.getNext().getNext()
	 * 	4. Handle size 2: If next == null; current = head; current.setNext(previous); previous.setNext(null)
	 * 	5. Repeat below steps till next != null 
	 * 			a) current.setNext(previous)
	 * 			b) previous = current
	 * 			c) current =  next
	 */
	public void  reverse() {
		// List is empty
		if(head == null) {
			System.out.println("List is empty");
		}
		
		else if(head.getNext()  == null)
			return;
		else {
			Node previous = head;
			Node current  = head.getNext();
			Node next = head.getNext().getNext();
			
			if(next == null) {
				current = head;
				current.setNext(previous);
				previous.setNext(null);
				return;
			}
			
			else {
				previous.setNext(null);
				while(current != null) {
					current.setNext(previous);
					head = current;
					previous = current;
					current = next;
					if(next != null)
						next = next.getNext();		
				}
			}		
		}
	}
	
	public void reverseRecursive() {
		reverseRecursiveInternal(null,  head);
	}
	
	private void reverseRecursiveInternal(Node  previous, Node current) {
		if(current ==  null) {
			head  = previous;
			return;
		}
		else {
			Node temp = current.getNext();
			current.setNext(previous);
			previous  = current;
			current =  temp;
			
			reverseRecursiveInternal(previous, current);
		}
	}
	// Runner Technique
	public void changeSequenceFromMiddle() {
		/**
		 * Handle below cases
		 * 	1. If  list is  empty
		 * 	2. If list has size <=3, return
		 * 	3. If list size is 4 or above:
		 * 		a) Two nodes: fast and slow: fast moves in 2X and slow moves in 1X
		 * 		b) When  fast==null || fast.next == null, slow is in  middle
		 * 		c) Set fast to head
		 * 		d) Two nodes: fNext  = fast.next and  sNext = slow.next
		 * 		e) While slow.next != null,
		 * 			i)fast.next  = slow; fast.next.next = fNext; fast = fast.next.next; slow = slow.next 
		 */
		
		if(head == null) {
			System.out.println("Linked list is empty");
			return;
		}
		if(size <= 3)
			return;
		else {
			Node fast = head;
			Node slow = head;
			
			while(fast != null && fast.getNext()!= null) {
				fast = fast.getNext().getNext();
				slow = slow.getNext();
			}
			
			fast = head;
			
			while(slow.getNext().getNext()  != null) {
				Node temp = fast.getNext();
				temp.setNext(null);
				fast.setNext(slow);
				slow = slow.getNext();
				fast.getNext().setNext(temp);
				fast = fast.getNext().getNext();
			}
		}
	}
	
	public void deleteAllOccurences(int data) {
		/**
		 * Handle following cases
		 * 	1. When list is empty  - SYSO  List is empty
		 * 	2. While head is matching - set head to null and  size--
		 * 	3. When list has more than  one node
		 * 		a) Node prev = head, curr = head.next
		 * 		b) if curr.data == data,  Node temp = curr, prev.next = curr.next, curr = curr.next, temp.next =null
		 * 		c) else, prev = prev.next, curr = curr.next
		 */
		
		if(head == null) {
			System.out.println("List is empty");
			return;
		}
		
		while(head.getData() == data) {
			Node temp =  head;
			head = temp.getNext();
			temp.setNext(null);
			size--;
		}
		
		Node  prev = head;
		Node curr =  head.getNext();
		
		while(curr!=null) {
			if(curr.getData() == data) {
				Node temp = curr;
				prev.setNext(curr.getNext());
				curr = curr.getNext();
				temp.setNext(null);
			}
			else {
				prev = prev.getNext();
				curr = curr.getNext();
			}
		}
	}
	
	
	// Verify this logic
	public  void  appendAscend(int data) {
		/**
		 * Following  conditions to be handled
		 * 	1. List is empty : create new node and set it to head
		 * 	2. If head.data == data, Node temp = head; head = newNode; head.next = temp
		 * 	3. List has one or more nodes
		 * 		a) create new node
		 * 		b) Node curr = head.next; while curr.getNext != null, if curr.data >= data, temp = curr.next; data.next = temp; curr.next = data
		 */
		Node node = new Node(data);
		if(head == null) {
			head = node;
			size++;
			return;
		}
		if(head.getData() == data) {
			Node temp = head;
			head = node;
			head.setNext(temp);
			size ++;
			return;
		}
		Node prev = head;
		Node curr = head.getNext();
		if(curr == null) {
			curr  = node;
			size++;
			return;
		}
		while(curr.getNext()!=null) {
			if(curr.getData() == data) {
				Node  temp = curr.getNext();
				node.setNext(temp);
				curr.setNext(node);
				size ++;
				return;
			} else if(data <curr.getData()) {
				prev.setNext(node);
				node.setNext(curr);
				size++;
				return;
			}
			else {
				prev = prev.getNext();
				curr = curr.getNext();
			}
		}
		curr.setNext(node);
		size++;
	}
	
	
}
