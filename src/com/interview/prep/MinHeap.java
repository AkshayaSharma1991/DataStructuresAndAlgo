/**
 * 
 */
package com.interview.prep;

/**
 * @author akshayas
 *
 */
public class MinHeap {

	int capacity = 10;
	private HeapNode[] heap = new HeapNode[capacity];
	int size = 0;

	public int getLeftChildIndex(int parentIndex) {
		return 2 * parentIndex + 1;
	}

	public int getRightChildIndex(int parentIndex) {
		return 2 * parentIndex + 2;
	}

	public int getParentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}

	public boolean hasLeftChild(int parentIndex) {
		return getLeftChildIndex(parentIndex) < size;
	}

	public boolean hasRightChild(int parentIndex) {
		return getRightChildIndex(parentIndex) < size;
	}

	public boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}

	public int getLeftChild(int parentIndex) {
		return heap[getLeftChildIndex(parentIndex)].element;
	}

	public int getRightChild(int parentIndex) {
		return heap[getRightChildIndex(parentIndex)].element;
	}

	public int getParent(int index) {
		return heap[getParentIndex(index)].element;
	}

	void swap(int x, int y) {
		HeapNode temp = heap[x];
		heap[x] = heap[y];
		heap[y] = temp;
	}

	public int peek() {
		return heap[size].element;
	}

	public HeapNode pop() {
		HeapNode item = heap[0];
		swap(0, size - 1);
		size--;
		heapifyDown();
		return item;
	}

	private void heapifyDown() {
		int index = 0;
		while (hasLeftChild(index)) {
			int smallerChildIndex = getLeftChildIndex(index);
			if (hasRightChild(index) && getRightChild(index) < getLeftChild(index))
				smallerChildIndex = getRightChildIndex(index);

			if (heap[index].element < heap[smallerChildIndex].element)
				break;
			else {
				swap(index, smallerChildIndex);
				index = smallerChildIndex;
			}
		}
	}

	public void add(HeapNode item) {
		heap[size] = item;
		size++;
		heapifyUp();
	}

	public void heapifyUp() {
		int index = size - 1;
		while (hasParent(index) && getParent(index) > heap[index].element) {
			swap(index, getParentIndex(index));
			index = getParentIndex(index);
		}

	}

	public void printHeap() {
		for (int i = 0; i < size; i++) {
			System.out.print(" " + heap[i].element);
		}
	}

}

class HeapNode {
	int element;
	int i;
	int j;

	public HeapNode(int element, int i, int j) {
		this.element = element;
		this.i = i;
		this.j = j;
	}
	
	public String toString() {
		return String.valueOf(this.element);
	}
}
