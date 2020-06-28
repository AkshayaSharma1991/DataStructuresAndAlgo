/**
 * 
 */
package com.dsa.genericLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author akshayas
 *
 */
public class GenericLinkedList<T> implements Iterable<T>{
	
	private GenericNode<T> head;
	private int size;
	
	public GenericLinkedList(){
		
	}
	
	public GenericLinkedList(GenericNode<T>  head) {
		this.head = head;
	}

	/**
	 * @return the head
	 */
	public GenericNode<T> getHead() {
		return head;
	}

	/**
	 * @param head the head to set
	 */
	public void setHead(GenericNode<T> head) {
		this.head = head;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}
	
	public void append(T data) {
		GenericNode<T> newNode = new GenericNode<T>(data);
		if(isEmpty()) {
			head  = newNode;
			size++;
			return;
		}else {
			GenericNode<T> temp  = head;
			while(temp.getNext()!=null) {
				temp = temp.getNext();
			}
			temp.setNext(newNode);
			size++;
			return;
		}
	}
	
	
	public boolean isEmpty() {
		return head  == null;
	}

	/* (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator<T>();
	}

	class LinkedListIterator<T> implements Iterator<T>{

		private GenericNode<T> currentNode = null;
		
		@Override
		public boolean hasNext() {
			if(currentNode!= null)
				return currentNode.getNext()!=null;
			else
				return !isEmpty();
		}

		/* (non-Javadoc)
		 * @see java.util.Iterator#next()
		 */
		@Override
		public T next() {
			if (currentNode ==  null) {
				currentNode = (GenericNode<T>) head;
				return currentNode.getData();	
			}else {
				if(currentNode.getNext()==null)
					throw  new NoSuchElementException();
				else {
					currentNode  = currentNode.getNext();
					return  currentNode.getData();
				}
			}
		}

	}
	
	public void delete(T data) {
		
	}
}
