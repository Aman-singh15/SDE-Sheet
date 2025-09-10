/*Given an undirected graph with V vertices and E edges, represented as a 2D vector edges[][], where each entry edges[i] = [u, v] denotes an edge between vertices u and v, determine whether the graph contains a cycle or not. The graph can have multiple component.
Examples:
Input: V = 4, E = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 3]]
Output: true
Explanation: 
1 -> 2 -> 0 -> 1 is a cycle.
Input: V = 4, E = 3, edges[][] = [[0, 1], [1, 2], [2, 3]]
Output: false
Explanation: 
No cycle in the graph.
Constraints:
1 ≤ V ≤ 105
1 ≤ E = edges.size() ≤ 105
Expected Complexities
Time Complexity: O(V + E)
Auxiliary Space: O(V)
*/



// class Solution {
//     public boolean isCycle(int V, int[][] edges) {
//         int m = edges.length;
//         int[][] adj = new int[V][V];

//         for (int i = 0; i < m; i++) {
//             int u = edges[i][0];
//             int v = edges[i][1]; 
//             adj[u][v] = 1;
//             adj[v][u] = 1;
//         }

//         boolean[] visited = new boolean[V];
    
// //         for (int i = 0; i < V; i++) {
// //             if (!visited[i]) {
// //                 if (dfs(adj, i, visited, -1,V)) {  
// //                     return true;
// //                 }
// //             }
// //         }
// //         return false;
// //     }

// //   public boolean dfs(int[][] adj, int sv, boolean[] visited, int parent,int V) {
// //       visited[sv]= true;
// //       for(int i=0;i<V;i++){
// //           if(adj[sv][i]==1){
// //           if( !visited[i]){
// //               if(dfs(adj,i,visited,sv,V)){
// //                   return true;
// //               }
// //           }else if(parent!=i){
// //               return true;
// //           }
// //           }
// //       }
// //       return false;
       
// //   }
// // }
// //   BFS using Adjacency matrix 
//   for(int i=0;i<V;i++){
//       if(!visited[i]){
//           if(bfs(adj,i,visited,V)){
//               return true;
//           }
//       }
//   }
//   return false;
// }
//   public boolean bfs(int[][]adj, int sv,boolean[]visited, int V){
//          Queue<int[]>queue = new LinkedList<>();
//          queue.add(new int[]{sv,-1});
//          visited[sv]=true;
//          while(!queue.isEmpty()){
//              int front[] = queue.poll();
//              int node = front[0];
//              int parent = front[1];
//              for(int i=0;i<V;i++){
//                  if(adj[node][i]==1){
//                      if(!visited[i]){
//                          visited[i]=true;
//                          queue.add(new int[]{i,node});
//                      }else if(parent!=i){
//                          return true;
//                      }
//                  }
//              }
             
//          }
//          return false;
//   }
// }


// USING ADJECENCY LIST

import java.util.*;

class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Build adjacency list
        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adj[u].add(v);
            adj[v].add(u); // undirected
        }

        boolean[] visited = new boolean[V];

        // Run BFS for all components
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfs(adj, i, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean bfs(List<Integer>[] adj, int sv, boolean[] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sv, -1});
        visited[sv] = true;

        while (!queue.isEmpty()) {
            int[] front = queue.poll();
            int node = front[0];
            int parent = front[1];

            for (int neighbor : adj[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(new int[]{neighbor, node});
                } else if (neighbor != parent) {
                    return true; // cycle detected
                }
            }
        }
        return false;
    }
}
