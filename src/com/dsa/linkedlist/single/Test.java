package com.dsa.linkedlist.single;

public class Test {

	public static void main(String[] args) {
		/*SinglyLinkedList sll = new SinglyLinkedList();
		sll.isListSizeEven();
		sll.appendAscend(6);
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
		sll.reverseRecursive();
		sll.traverse();
		sll.deleteAllOccurences(9);
		sll.traverse();
		System.out.println("5th index from last:  " + sll.getKthElementFromLast(5));
		System.out.println("Is list size even: " + sll.isListSizeEven());
		System.out.println(sll.getMiddle());
		sll.delete(3);
		sll.traverse();
		System.out.println("Is list size even: " + sll.isListSizeEven());
		System.out.println(sll.getMiddle());*/
		
		SinglyLinkedList l1 = new SinglyLinkedList();
		l1.append(7);
		l1.append(9);
		l1.append(9);
		l1.append(8);
		l1.changeSequenceFromMiddle();
		
		SinglyLinkedList l2 = new SinglyLinkedList();
		l2.append(7);
		l2.append(8);
		l2.append(9);
		l2.append(10);
		l2.changeSequenceFromMiddle();

		l1.traverse();
		l2.traverse();
		System.out.println("Intersection node: " + LinkedListUtil.getIntersectionNode(l1, l2));
		LinkedListUtil.addList(l1, l2).traverse();
		LinkedListUtil.addNodeToBeginningOfList(l1, 5);
		l1.traverse();
		LinkedListUtil.addNodeAfter(l1, 9, 10);
		l1.traverse();
		System.out.println("Node  length:  " + LinkedListUtil.getLength(l1));
		LinkedListUtil.delete(l1,18);
		System.out.println("Is 8 available in list: " + LinkedListUtil.search(l1, 8) );
		
		l1.traverse();
		LinkedListUtil.deleteAt(l1, 0);
		l1.traverse();
		System.out.println("Node  length:  " + LinkedListUtil.getLengthRecMethod(l1));
		System.out.println("Is 5 available in list: " + LinkedListUtil.search(l1, 5) );
	}

}
