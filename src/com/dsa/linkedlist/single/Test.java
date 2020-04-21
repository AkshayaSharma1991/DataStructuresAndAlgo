package com.dsa.linkedlist.single;

public class Test {

	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.isListSizeEven();
		sll.append(1);
		System.out.println("Is list size even: " + sll.isListSizeEven());
		sll.append(2);
		sll.append(4);
		sll.append(6);
		sll.append(8);
		sll.append(9);
		sll.append(3);
		sll.printReverse();
		System.out.println("Kth index from last:  " + sll.getKthElementFromLast(5));
		sll.traverse();
		System.out.println("Is list size even: " + sll.isListSizeEven());
		System.out.println(sll.getMiddle());
		sll.delete(3);
		sll.traverse();
		System.out.println("Is list size even: " + sll.isListSizeEven());
		System.out.println(sll.getMiddle());
	}

}
