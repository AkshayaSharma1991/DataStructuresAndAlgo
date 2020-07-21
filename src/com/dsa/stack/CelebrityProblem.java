/**
 * 
 */
package com.dsa.stack;

/**
 * @author akshayas
 *
 */
public class CelebrityProblem {

	static int matrix[][] = { { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 } };

	public static void main(String[] args) {
		System.out.println(findCelebrity(matrix.length));
	}

	static boolean knows(int a, int b) {
		boolean res = (matrix[a][b] == 1) ? true : false;
		return res;
	}
	
	static int findCelebrity(int n) {
		Stack stack =  new Stack();
		for(int i=0;i<n;i++) {
			stack.push(i);
		}
		
		while(stack.size>1) {
			int a = stack.pop();
			int b = stack.pop();
			
			boolean knows = knows(a,b);
			
			if(knows)
				stack.push(b);
			else
				stack.push(a);
		}
		
		int candidate = stack.pop();
		
		for(int i=0; i<n;i++) {
			if(i != candidate && !knows(i,candidate) || knows(candidate,i))
				return -1;
		}
		
		return candidate;
	}
}
