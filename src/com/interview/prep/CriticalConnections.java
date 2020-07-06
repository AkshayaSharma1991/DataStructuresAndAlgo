/**
 * 
 */
package com.interview.prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author akshayas
 *
 */
class CriticalConnections {

	List<Integer>[] graph;
	List<Integer> criticalConnections;
	int[] visitedTimes;
	int[] lowTimes;
	int time;

	public List<Integer> criticalConnections(int n, List<List<Integer>> connections) {
		graph = new ArrayList[n];
		criticalConnections = new ArrayList<>();
		visitedTimes = new int[n];
		lowTimes = new int[n];
		time = 0;

		buildAdjacency(connections);
		boolean[] visited = new boolean[n];
		dfs(visited, 0, -1);
		return criticalConnections;
	}

	private void dfs(boolean[] visited, int cNode, int pNode) {
		visited[cNode] = true;
		visitedTimes[cNode] = lowTimes[cNode] = time++;

		for (int neighbor : graph[cNode]) {
			if (neighbor == pNode)
				continue;
			if (!visited[neighbor]) {
				dfs(visited, neighbor, cNode);
				lowTimes[cNode] = Math.min(lowTimes[cNode], lowTimes[neighbor]);
				if (visitedTimes[cNode] < lowTimes[neighbor]) {
					criticalConnections.add(cNode);
				}
			} else {
				lowTimes[cNode] = Math.min(lowTimes[cNode], visitedTimes[neighbor]);
			}
		}
	}

	private void buildAdjacency(List<List<Integer>> connections) {
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		for (List<Integer> connection : connections) {
			int a = connection.get(0);
			int b = connection.get(1);
			graph[a].add(b);
			graph[b].add(a);
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> connections = new ArrayList<>();
		connections.add(Arrays.asList(0, 1));
		connections.add(Arrays.asList(0, 2));
		connections.add(Arrays.asList(1, 3));
		connections.add(Arrays.asList(2, 3));
		connections.add(Arrays.asList(2, 5));
		connections.add(Arrays.asList(5, 6));
		connections.add(Arrays.asList(3, 4));
		CriticalConnections cc = new CriticalConnections();
		int numNodes = 7;
		List<Integer> cConnections = cc.criticalConnections(numNodes, connections);
		System.out.println(cConnections);
	}
}
