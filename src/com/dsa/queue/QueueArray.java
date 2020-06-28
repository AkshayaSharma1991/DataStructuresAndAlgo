/**
 * 
 */
package com.dsa.queue;

/**
 * @author akshayas
 *
 */
/**
 * Array implementation of a queue.
 * Methods covered: arrayEnqueue
 * 					arrayDequeue
 * 					showFront
 * 					listContents
 *
 */
public class QueueArray {

	private int rear,  front, capacity,  size;
	private int[]  queue;
	
	public QueueArray(int c) {
		capacity = c;
		queue = new int[capacity];
		front = rear = 0;
	}
	
	public void enqueue(int data) {
		if(capacity==rear) {
			System.out.println("Queue is full");
			return;
		}
		else {
			queue[rear]= data;
			System.out.println("Enqueued: " + data);
			rear++;
			return;
		}
	}
	
	public void dequeue() {
		if(front == rear) {
			System.out.println("Queue is empty");
			return;
		}
		else {
			int data = queue[front];
			for(int i=0; i< rear -1; i++) {
				queue[i] = queue[i+1];
			}
			if(rear < capacity)
				queue[rear] = 0;
			rear--;
			if(front == rear)
				queue[front]  = 0;
			System.out.println("Dequeued: " + data);
		}
	}
	
	public  void getFront() {
		if(front == rear)
			System.out.println("Queue is empty");
		else
			System.out.println("Front of queue: "  +  queue[front]);
	}
	
	public boolean  isEmpty() {
		return  front == rear;
	}
	
	public void listElements() {
		if(front == rear)
			System.out.println("Queue is empty");
		else {
			for(int i=0; i< rear; i++) {
				System.out.println(queue[i]);
			}
		}
	}
}
