/**
 * 
 */
package com.dsa.queue;

/**
 * @author akshayas
 *
 */
public class QueueCircularArray {
	
	private int  front,rear,capacity;
	private int[] queue;
	
	public QueueCircularArray(int c) {
		front = rear =-1;
		capacity =  c;
		queue  =  new int[capacity];
	}

	public void enqueue(int  data) {
		if(isFull())
			System.out.println("Queue is full");
		else  if(isEmpty()) {
			front = (front + 1)%capacity;
			queue[front]  = data;
		}
		else {
			rear = (rear +1)  % capacity;
			queue[rear] = data;
		}
	}
	
	public void dequeue(int  data) {
		if(isEmpty())
			System.out.println("Queue is empty");
		else {
			
			queue[++front] = data;
		}
	}
	
	public boolean  isEmpty() {
		return (front == -1) && (rear ==-1);
	}
	public boolean isFull() {
		return (rear + 1) % queue.length ==  front;
	}
	
	
}
