/**
 * 
 */
package com.dsa.queue;

/**
 * @author akshayas
 *
 */
public class TestQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Queue  q =  new Queue();
		q.enqueue(5);
		System.out.println(q.isEmpty());
		System.out.println(q.deQueue());
		q.enqueue(6);
		q.enqueue(9);
		q.enqueue(234);
		System.out.println(q.deQueue());
		
		
		QueueArray  q1 =  new QueueArray(5);
		q1.enqueue(5);
		q1.enqueue(10);
		q1.enqueue(20);
		q1.enqueue(30);	
		q1.enqueue(40);
		q1.enqueue(50);
		q1.listElements();
		q1.dequeue();
		q1.listElements();
		q1.dequeue();
		q1.listElements();
		q1.dequeue();
		q1.listElements();
		q1.dequeue();
		q1.listElements();
		q1.dequeue();
		q1.listElements();
		q1.dequeue();
		q1.getFront();
		q1.enqueue(5);
		q1.listElements();
	}

}
