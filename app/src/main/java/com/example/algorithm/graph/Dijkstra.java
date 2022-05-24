package com.example.algorithm.graph;

// 一篇文章講透Dijkstra最短路徑演算法: https://iter01.com/508741.html
// https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
public class Dijkstra {

    int minDistance(int[] dist, Boolean[] sptSet) {

        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < dist.length; v++)
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    // Function that implements Dijkstra's single source shortest path
    // algorithm for a graph represented using adjacency matrix
    // representation
    public int[] dijkstra(int[][] graph, int src) {
        int length = graph.length;
        int[] dist = new int[graph.length]; // The output array. dist[i] will hold
        // the shortest distance from src to i

        // sptSet[i] will true if vertex i is included in shortest
        // path tree or shortest distance from src to i is finalized
        Boolean[] visited = new Boolean[length];

        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < length; i++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        // Distance of source vertex from itself is always 0
        dist[src] = 0;

        // Find shortest path for all vertices
        for (int count = 0; count < length - 1; count++) {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = minDistance(dist, visited);

            // Mark the picked vertex as processed
            visited[u] = true;

            // Update dist value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < length; v++)

                // Update dist[v] only if is not in sptSet, there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of dist[v]
                if (!visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }

        // print the constructed distance array
        return dist;
    }

}