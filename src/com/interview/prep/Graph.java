/**
 * 
 */
package com.interview.prep;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author akshayas
 *
 */
class Graph {
	private int V;
	private LinkedList<Integer> adj[];

	@SuppressWarnings("unchecked")
	public Graph(int v) {
		V = v;
		adj = new LinkedList[V];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	void bfs(int s) {
		boolean[] visited = new boolean[V];
		LinkedList<Integer> queue = new LinkedList<>();

		visited[s] = true;
		queue.add(s);

		while (!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(" " + current);

			Iterator<Integer> i = adj[current].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}

	void dfs(int s) {
		boolean[] visited = new boolean[V];
		dfsUtil(s, visited);
	}

	void dfsUtil(int s, boolean[] visited) {
		visited[s] = true;
		System.out.print(" " + s);
		Iterator<Integer> i = adj[s].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n]) {
				dfsUtil(n, visited);
			}
		}
	}

	public static void main(String args[]) {
		Graph g = new Graph(5);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(2, 4);

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

		g.bfs(0);

		System.out.println("\nFollowing is Depth First Traversal " + "(starting from vertex 2)");

		g.dfs(0);
	}
}
