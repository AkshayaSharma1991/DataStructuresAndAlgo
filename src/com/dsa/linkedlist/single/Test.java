package com.dsa.linkedlist.single;

public class Test {

	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.isListSizeEven();
		sll.appendAscend(1);
		sll.appendAscend(1);
		System.out.println("Is list size even: " + sll.isListSizeEven());
		sll.appendAscend(2);
		sll.appendAscend(4);
		sll.appendAscend(6);
		sll.appendAscend(8);
		sll.appendAscend(9);
		sll.appendAscend(9);
		sll.appendAscend(9);
		sll.appendAscend(9);
		sll.appendAscend(9);
		sll.appendAscend(3);
		sll.printReverse();
		sll.reverse();
		sll.traverse();
		sll.deleteAllOccurences(9);
		sll.traverse();
		System.out.println("5th index from last:  " + sll.getKthElementFromLast(5));
		System.out.println("Is list size even: " + sll.isListSizeEven());
		System.out.println(sll.getMiddle());
		sll.delete(3);
		sll.traverse();
		System.out.println("Is list size even: " + sll.isListSizeEven());
		System.out.println(sll.getMiddle());
	}

}
