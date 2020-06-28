/**
 * 
 */
package com.dsa.linkedlist.single;

/**
 * @author akshayas
 *
 */
public class LinkedListUtil {
	
	public static SinglyLinkedList addList(SinglyLinkedList l1, SinglyLinkedList l2) {
		NodeSum totalSum = addListHelper(l1.getHead(), l2.getHead());
		int carry = totalSum.carry;
		Node headNode = null;
		if(carry  >0) {
			headNode = new Node(carry);
			headNode.setNext(totalSum.node);
		}
		else {
			headNode = totalSum.node;
		}
		return new SinglyLinkedList(headNode);
	}
	
	public static NodeSum addListHelper(Node n1, Node n2) {
		if(n1 == null &&  n2==null) {
			return new NodeSum(0, null);
		}
		else {
			NodeSum  ns =  addListHelper(n1.getNext(), n2.getNext());
			//Post  processing
			int sum = ns.carry +  n1.getData() + n2.getData();
			Node newNode = new Node(sum %10);
			newNode.setNext(ns.node);
			int newCarry = sum/10;
			NodeSum newNodeSum = new NodeSum(newCarry, newNode);
			return newNodeSum;
		}
	}
	
	//At the front of the linked list
	public static void addNodeToBeginningOfList(SinglyLinkedList l1, int data) {
		Node n = new Node(data);
		n.setNext(l1.getHead());
		l1.setHead(n);
		l1.setSize(l1.getSize()+1);
	}
	
	//After a given node
	public static void addNodeAfter(SinglyLinkedList l1, int addAfter, int data) {
		if(l1.getHead() == null) {
			System.out.println("List is empty");
			return;
		}else {
			Node temp = l1.getHead();
			while(temp!=null) {
				if(temp.getData() == addAfter) {
					Node n = new Node(data);
					Node next = temp.getNext();
					temp.setNext(n);
					n.setNext(next);
					return;
				}else
					temp = temp.getNext();
			}
		}
	}
	
	public static void delete(SinglyLinkedList l1, int data) {
		if(l1.getHead() == null) {
			System.out.println("List is empty");
		}else {
			Node temp = l1.getHead();
			Node prev = l1.getHead();
			if(l1.getHead().getData() == data) {
				l1.setHead(temp.getNext());
				temp.setNext(null);
				l1.setSize(l1.getSize()-1);
				return;
			}else {
				temp = temp.getNext();
				while(temp!=null) {
					if(temp.getData() == data) {
						prev.setNext(temp.getNext());
						temp.setNext(null);
						l1.setSize(l1.getSize()-1);
						return;
					}
					else {
						temp = temp.getNext();
						prev = prev.getNext();
					}
				}
				System.out.println("Data not found in list");
			}
		}
		
	}
	
	public static void deleteAt(SinglyLinkedList l1, int index) {
		if(l1.getHead() == null)
			System.out.println("List is empty");
		else {
			if(l1.getSize()  <  index +1) {
				System.out.println("Index: " +  index +  " is greater than list size: " + l1.getSize());
				return;
			}
			else {
				Node temp = l1.getHead();
				Node prev = l1.getHead();
				if(index == 0) {
					l1.setHead(temp.getNext());
					temp.setNext(null);
					l1.setSize(l1.getSize()-1);
					return;
				}
				else {
					temp = temp.getNext();
					int counter = 1;
					while(counter <= index-1) {
						temp = temp.getNext();
						prev = prev.getNext();
						counter++;
					}
					prev.setNext(temp.getNext());
					temp.setNext(null);
					l1.setSize(l1.getSize()-1);
					return;
				}
			}
		}
	}
	
	public static int getLength(SinglyLinkedList l1) {
		if(l1.getHead() == null) 
			return 0;
		else {
			int  count = 0;
			Node temp  = l1.getHead();
			while(temp != null) {
				temp  = temp.getNext();
				count++;
			}
			return count;
		}
	}
	
	public static int getLengthRecMethod(SinglyLinkedList l1) {
		if(l1.getHead() == null) 
			return 0;
		else {
			return getCount(l1.getHead());
		}
	}
	
	private static int getCount(Node n) {
		if(n==null)
			return  0;
		else
			return 1+getCount(n.getNext());
	}
	
	public static boolean search(SinglyLinkedList  l1, int data) {
		if(l1.getHead() == null)
			return false;
		else {
			Node  temp = l1.getHead();
			while(temp != null) {
				if(temp.getData() == data)
					return true;
				else
					temp = temp.getNext();
			}
			return false;
		}
	}
	
	public static boolean searchRecursive(SinglyLinkedList  l1, int data) {
		if(l1.getHead() == null)
			return false;
		else {
			return searchRec(l1.getHead(), data);
		}
	}
	
	private static boolean searchRec(Node n,  int data) {
		if(n == null)
			return false;
		else if(n.getData() == data)
			return true;
		else
			return searchRec(n.getNext(), data);
	}
	
	public static int getIntersectionNode(SinglyLinkedList l1,  SinglyLinkedList l2) {
		int c1 = getLength(l1);
		int c2 = getLength(l2);
		int d = 0;
		if(c1>c2) {
			d = c1-c2;
			return _getIntersectionNode(d, l1.getHead(), l2.getHead());
		}else {
			d = c2 - c1;
			return _getIntersectionNode(d, l2.getHead(), l1.getHead());
		}
	}
	
	private static int _getIntersectionNode(int d, Node n1, Node n2) {
		//Assumption: n1 is head of bigger list
		Node current1 = n1;
		Node current2 = n2;
		for(int i=0; i<d; i++) {
			current1  = current1.getNext();
		}
		while(current1 != null && current2 !=null) {
			if(current1.getData()  == current2.getData()) {
				return current1.getData();
			}
			current1 = current1.getNext();
			current2 = current2.getNext();
		}
		return 0;
	}
}
