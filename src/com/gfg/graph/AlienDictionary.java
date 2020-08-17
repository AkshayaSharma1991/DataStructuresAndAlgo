/**
 * 
 */
package com.gfg.graph;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author akshayas
 *
 */
public class AlienDictionary {

	public static void main(String[] args) {
		String[] words = {"caa", "aaa", "aab"}; 
        printOrder(words, 3); 
	}

	static void printOrder(String[] words, int alpha) {
		AlienGraph graph = new AlienGraph(alpha);
		for(int i=0; i<words.length-1;i++) {
			String word1 = words[i];
			String word2 = words[i+1];
			for(int j=0; j< Math.min(word1.length(), word2.length()); j++) {
				if(word1.charAt(j)!=word2.charAt(j)) {
					graph.addEdge(word1.charAt(j)-'a', word2.charAt(j)-'a');
					break;
				}
			}
		}
		graph.topologicalSort();
	}
}

class AlienGraph {
	public LinkedList<Integer>[] adjacencyList;

	public AlienGraph(int vertices) {
		adjacencyList = new LinkedList[vertices];
		for (int i = 0; i < vertices; i++) {
			adjacencyList[i] = new LinkedList<>();
		}
	}

	public void addEdge(int startIndex, int endIndex) {
		adjacencyList[startIndex].add(endIndex);
	}

	private int numberOfVertices() {
		return adjacencyList.length;
	}

	public void topologicalSort() {
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[numberOfVertices()];
		for(int i=0; i<numberOfVertices(); i++) {
			if(!visited[i]) {
				topologicalSortUtil(i, visited, stack);
			}
		}
		while(!stack.isEmpty()) {
			System.out.print((char)( 'a' + stack.pop()) + " ");
		}
	}

	private void topologicalSortUtil(int currVertex, boolean[] visited, Stack stack) {
		visited[currVertex] = true;
		for (int adjacencyVertex : adjacencyList[currVertex]) {
			if (!visited[adjacencyVertex]) {
				topologicalSortUtil(adjacencyVertex, visited, stack);
			}
		}
		stack.push(currVertex);
	}
}
