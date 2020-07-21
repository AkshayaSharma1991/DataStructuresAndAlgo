/**
 * 
 */
package com.gfg.graph;

/**
 * @author akshayas
 *
 */
public class DijkstrasShortestPath {
	
	static final int V = 9;
	
	public static void main(String[] args) {
		/* Let us create the example graph discussed above */
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
                                      { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
                                      { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
                                      { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
                                      { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
                                      { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
                                      { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
                                      { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
                                      { 0, 0, 2, 0, 0, 0, 6, 7, 0 } }; 
       dijkstrasAlgo(graph, 0);
	}
	
	static int minDistance(int[] dist, boolean[] sptSet) {
		int min = Integer.MAX_VALUE, min_index = -1;
		for(int v=0; v<V;v++) {
			if(!sptSet[v]  && dist[v]<=min) {
				min = dist[v];
				min_index = v;
			}
		}
		
		return min_index;
	}
	
	static void dijkstrasAlgo(int[][] graph, int src) {
		
		// create a distance array holding shortest distance from 0 to i
		int[] dist = new int[V];
		
		// is set to true if the shortest path is already set for the index
		boolean[] sptSet = new boolean[V];	
		
		//Initialize the dist array 
		for(int i=0; i<V; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		// Distance of 0 from 0 is 0
		dist[0] = 0;
		
		// Iterate through the dist array
		for(int i=0; i<V-1; i++) {
			// find  the shortest path to this vertex
			int u = minDistance(dist, sptSet);
			
			sptSet[u]  = true;
			
			for(int j=0;j<V; j++) {
				if(!sptSet[j] && graph[u][j]!=0 && dist[u]!=Integer.MAX_VALUE && dist[u]+graph[u][j] < dist[j]) {
					dist[j] = dist[u]+graph[u][j];
				}
			}
		}
		printSolution(dist, V);
	}
	static void printSolution(int dist[], int n) 
    { 
        System.out.println("Vertex   Distance from Source"); 
        for (int i = 0; i < V; i++) 
            System.out.println(i + " tt " + dist[i]); 
    } 
}
