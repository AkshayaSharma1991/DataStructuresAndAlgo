/**
 * 
 */
package com.interview.prep;

/**
 * @author akshayas
 *
 */
public class CopyListWithRandomPointer {

	public static void main(String[] args) {
		Node start = new Node(1);
		start.next = new Node(2);
		start.next.next = new Node(3);
		start.next.next.next = new Node(4);
		start.next.next.next.next = new Node(5);

		// 1's random points to 3
		start.random = start.next.next;

		// 2's random points to 1
		start.next.random = start;

		// 3's and 4's random points to 5
		start.next.next.random = start.next.next.next.next;
		start.next.next.next.random = start.next.next.next.next;

		// 5's random points to 2
		start.next.next.next.next.random = start.next;

		System.out.println("Original list : ");
		print(start);

		System.out.println("Cloned list : ");
		Node cloned_list = deepClone(start);
		print(cloned_list);
	}

	static Node deepClone(Node head) {
		Node curr = head, temp = null;

		// Copied nodes to intermittent position in original array
		while (curr != null) {
			temp = curr.next;
			Node n = new Node(curr.val);
			curr.next = n;
			curr.next.next = temp;
			curr = temp;
		}
		curr = head;
		// Set random values to the copied alternate elements
		while (curr != null) {
			curr.next.random = curr.random.next;
			curr = curr.next.next;
		}

		// Split original and copy lists
		Node original = head, copy = head.next;
		temp = copy;

		while (original.next != null && copy.next != null) {
			original.next = original.next.next;
			copy.next = copy.next.next;

			original = original.next;
			copy = copy.next;
		}

		return temp;
	}

	static void print(Node start) {
		Node ptr = start;
		while (ptr != null) {
			System.out.println("Data = " + ptr.val + ", Random = " + ptr.random.val);
			ptr = ptr.next;
		}
	}
}

class Node {
	int val;
	Node next;
	Node random;

	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
}
