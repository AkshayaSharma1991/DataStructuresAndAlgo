/**
 * 
 */
package com.interview.prep;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author akshayas
 *
 */
public class MinCostToConnectRopes {

	public static void main(String[] args) {
		int[] files1 = {8, 4, 6, 12};
		System.out.println(costToConnect(files1));
	}
	
	static int costToConnect(int[] ropes) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for(int i:ropes) {
			queue.offer(i);
		}
		int totalCost =  0;
		while(queue.size()>1) {
			int r1  = queue.poll();
			int r2 = queue.poll();
			int temp = r1+r2;
			totalCost +=temp;
			queue.offer(temp);
		}
		
		return totalCost;
	}
}
