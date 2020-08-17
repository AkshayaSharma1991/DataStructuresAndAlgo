/**
 * 
 */
package com.gfg.graph;

import java.util.LinkedList;
import java.util.Stack;

import com.dsa.queue.Queue;

/**
 * @author akshayas
 *
 */
public class Graph {

	int V;
	LinkedList<Integer> adj[];

	@SuppressWarnings("unchecked")
	public Graph(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	void bfs(int s) {
		boolean[] visited = new boolean[V];
		Queue<Integer> queue = new Queue<>();

		queue.enqueue(s);
		while (!queue.isEmpty()) {
			int q = queue.deQueue();
			if (!visited[q]) {
				System.out.print(" " + q);
				visited[q] = true;
			}
			for (int adjacent : adj[q]) {
				if (!visited[adjacent])
					queue.enqueue(adjacent);
			}
		}
	}

	void dfs(int s) {
		dfsUtil(s, new boolean[V]);
	}

	void dfsUtil(int s, boolean[] visited) {
		visited[s] = true;
		System.out.print(" " + s);
		for (int adjacent : adj[s]) {
			if (!visited[adjacent])
				dfsUtil(adjacent, visited);
		}
	}

	boolean isCyclic() {
		boolean[] visited = new boolean[V];
		boolean[] recstack = new boolean[V];

		for (int i = 0; i < V; i++) {
			if (isCyclicUtil(i, visited, recstack))
				return true;
		}
		return false;
	}

	boolean isCyclicUtil(int i, boolean[] visited, boolean[] recstack) {
		if (recstack[i])
			return true;
		if (visited[i])
			return false;

		recstack[i] = true;
		visited[i] = true;

		for (int c : adj[i]) {
			if (isCyclicUtil(c, visited, recstack))
				return true;
		}

		recstack[i] = false;
		return false;
	}

	boolean isUndirectedCyclic() {
		boolean[] visited = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				if (isCyclicUndirectedUtil(i, visited, -1))
					return true;
			}
		}
		return false;
	}

	boolean isCyclicUndirectedUtil(int i, boolean[] visited, int parent) {
		if (visited[i])
			return false;
		visited[i] = true;
		for (int c : adj[i]) {
			if (visited[c]) {
				if (c != parent)
					return true;
			} else {
				if (isCyclicUndirectedUtil(c, visited, i))
					return true;
			}
		}
		return false;
	}

	void topologicalSort() {
		boolean[] visited = new boolean[V];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < V; i++) {
			if (!visited[i])
				topologicalSortUtil(i, visited, stack);
		}

		while (!stack.isEmpty())
			System.out.print(" " + stack.pop());
	}

	void topologicalSortUtil(int i, boolean[] visited, Stack<Integer> stack) {
		visited[i] = true;

		for (int c : adj[i]) {
			if (!visited[c]) {
				topologicalSortUtil(c, visited, stack);
			}
		}

		stack.add(i);
	}

	public static void main(String args[]) {
		Graph g = new Graph(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		g.topologicalSort();

	}
}
