/*Given an undirected, weighted graph with V vertices numbered from 0 to V-1 and E edges, represented by 2d array edges[][], where edges[i]=[u, v, w] represents the edge between the nodes u and v having w edge weight.
You have to find the shortest distance of all the vertices from the source vertex src, and return an array of integers where the ith element denotes the shortest distance between ith node and source vertex src.
Note: The Graph is connected and doesn't contain any negative weight edge.

Examples:
Input: V = 3, edges[][] = [[0, 1, 1], [1, 2, 3], [0, 2, 6]], src = 2
Output: [4, 3, 0]
Explanation:
Shortest Paths:
For 2 to 0 minimum distance will be 4. By following path 2 -> 1 -> 0
For 2 to 1 minimum distance will be 3. By following path 2 -> 1
For 2 to 2 minimum distance will be 0. By following path 2 -> 2
Input: V = 5, edges[][] = [[0, 1, 4], [0, 2, 8], [1, 4, 6], [2, 3, 2], [3, 4, 10]], src = 0
Output: [0, 4, 8, 10, 10]
Explanation: 
Shortest Paths: 
For 0 to 1 minimum distance will be 4. By following path 0 -> 1
For 0 to 2 minimum distance will be 8. By following path 0 -> 2
For 0 to 3 minimum distance will be 10. By following path 0 -> 2 -> 3 
For 0 to 4 minimum distance will be 10. By following path 0 -> 1 -> 4

Constraints:
1 ≤ V ≤ 105
1 ≤ E = edges.size() ≤ 105
0 ≤ edges[i][j] ≤ 104
0 ≤ src < V

*/



class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        ArrayList<List<int[]>>list = new ArrayList<>();
        for(int i=0;i<V;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int d=edges[i][2];
            list.get(u).add(new int[]{v,d});
            list.get(v).add(new int[]{u,d});
        }
           int distance[] = new int[V];
           for(int i=0;i<V;i++){
               distance[i]=Integer.MAX_VALUE;
           }
           distance[src]=0;
           boolean[]visited = new boolean[V];
        //  Queue<int[]>q= new LinkedList<>();
         PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
          q.add(new int[]{src,0});
          while(!q.isEmpty()){
              int cell[] = q.poll();
              int node = cell[0];
              int dist = cell[1];
              for(int i=0;i<list.get(node).size();i++){
                  int edge[]= list.get(node).get(i);
                  int neighbour=edge[0];
                  int wt=edge[1];
                      if(dist+wt<distance[neighbour]){
                      distance[neighbour]=dist+wt;
                      q.add(new int[]{neighbour,distance[neighbour]});
                  }
              }
          }
        return distance;
    }
}
    // original dijkstra
//             for(int i=0;i<V;i++){
//                 int minvertex = min(distance,visited);
//                 visited[minvertex]=true;
//                 for(int j=0;j<list.get(minvertex).size();j++){
//                     int edge[] =list.get(minvertex).get(j);
//                     int neighbour=edge[0];
//                     int wt=edge[1];
//                   if(!visited[neighbour]&& distance[minvertex]!=Integer.MAX_VALUE &&
//                   distance[neighbour]>distance[minvertex]+wt){
//                       distance[neighbour]=distance[minvertex]+wt;
//                   }
//                 }
//             }

//              return distance;
//     }
//     public int min(int[]distance,boolean[]visited){
//         int min=-1;
//         for(int i=0;i<distance.length;i++){
//             if(!visited[i] && (min==-1 || distance[i]<distance[min])){
//                 min=i;
//             }
//         }
//                 return min; 
//     }
// }
