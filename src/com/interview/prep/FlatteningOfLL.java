/**
 * 
 */
package com.interview.prep;

/**
 * @author akshayas
 *
 */
public class FlatteningOfLL {
	public static void main(String args[]) 
    { 
        LinkedList L = new LinkedList(); 
  
        /* Let us create the following linked list 
            5 -> 10 -> 19 -> 28 
            |    |     |     | 
            V    V     V     V 
            7    20    22    35 
            |          |     | 
            V          V     V 
            8          50    40 
            |                | 
            V                V 
            30               45 
        */
  
        L.head = L.push(L.head, 30); 
        L.head = L.push(L.head, 8); 
        L.head = L.push(L.head, 7); 
        L.head = L.push(L.head, 5); 
  
        L.head.right = L.push(L.head.right, 20); 
        L.head.right = L.push(L.head.right, 10); 
  
        L.head.right.right = L.push(L.head.right.right, 50); 
        L.head.right.right = L.push(L.head.right.right, 22); 
        L.head.right.right = L.push(L.head.right.right, 19); 
  
        L.head.right.right.right = L.push(L.head.right.right.right, 45); 
        L.head.right.right.right = L.push(L.head.right.right.right, 40); 
        L.head.right.right.right = L.push(L.head.right.right.right, 35); 
        L.head.right.right.right = L.push(L.head.right.right.right, 20); 
  
        // flatten the list 
        L.head = L.flatten(L.head); 
  
        L.printList(); 
    } 
}

class LinkedList {
	Node head; // head of list

	/* Linked list Node */
	class Node {
		int data;
		Node right, down;

		Node(int data) {
			this.data = data;
			right = null;
			down = null;
		}
	}

	Node push(Node head_ref, int data) {
		/*
		 * 1 & 2: Allocate the Node & Put in the data
		 */
		Node new_node = new Node(data);

		/* 3. Make next of new Node as head */
		new_node.down = head_ref;

		/* 4. Move the head to point to new Node */
		head_ref = new_node;

		/* 5. return to link it back */
		return head_ref;
	}

	void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.down;
		}
		System.out.println();
	}

	Node flatten(Node root) {
		if (root == null || root.right == null)
			return root;

		root.right = flatten(root.right);
		root = merge(root,root.right);
		return root;
	}

	Node merge(Node n1, Node n2) {
		if(n1==null) return  n2;
		if(n2==null) return n1;
		
		Node result;
		
		if(n1.data<n2.data) {
			result = n1;
			result.down = merge(n1.down,n2);
		} else {
			result = n2;
			result.down = merge(n1, n2.down);
		}
		
		result.right  = null;
		return result;
	}
}