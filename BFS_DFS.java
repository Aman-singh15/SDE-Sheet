/*Given a connected undirected graph containing V vertices, represented by a 2-d adjacency list adj[][], where each adj[i] represents the list of vertices connected to vertex i. Perform a Breadth First Search (BFS) traversal starting from vertex 0, visiting vertices from left to right according to the given adjacency list, and return a list containing the BFS traversal of the graph.
Note: Do traverse in the same order as they are in the given adjacency list.
Examples:
Input: adj[][] = [[2, 3, 1], [0], [0, 4], [0], [2]]
Output: [0, 2, 3, 1, 4]
Explanation: Starting from 0, the BFS traversal will follow these steps: 
Visit 0 → Output: 0 
Visit 2 (first neighbor of 0) → Output: 0, 2 
Visit 3 (next neighbor of 0) → Output: 0, 2, 3 
Visit 1 (next neighbor of 0) → Output: 0, 2, 3, 
Visit 4 (neighbor of 2) → Final Output: 0, 2, 3, 1, 4
Input: adj[][] = [[1, 2], [0, 2], [0, 1, 3, 4], [2], [2]]
Output: [0, 1, 2, 3, 4]
Explanation: Starting from 0, the BFS traversal proceeds as follows: 
Visit 0 → Output: 0 
Visit 1 (the first neighbor of 0) → Output: 0, 1 
Visit 2 (the next neighbor of 0) → Output: 0, 1, 2 
Visit 3 (the first neighbor of 2 that hasn't been visited yet) → Output: 0, 1, 2, 3 
Visit 4 (the next neighbor of 2) → Final Output: 0, 1, 2, 3, 4
Constraints:
1 ≤ V = adj.size() ≤ 104
1 ≤ adj[i][j] ≤ 104
*/




class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        
        // This is DFS logic
    //      ArrayList<Integer>list = new ArrayList<>();
       int V= adj.size();
    //   boolean[] visited = new boolean[V];
    //   for(int i=0;i<V;i++){
    //       if(!visited[i]){
    //          printdfs(i,list,adj,visited);
    //       }
    //   }
    //   return list;
    // }
    // public void printdfs(int i, ArrayList<Integer>list,ArrayList<ArrayList<Integer>>adj,boolean[] visited){
    //       list.add(i);
    //       visited[i]=true;
    //       for(int j=0;j<adj.get(i).size();j++){
    //              int neighbor = adj.get(i).get(j);
    //              if(!visited[neighbor]){
    //                 printdfs(neighbor,list,adj,visited);
    //           }
    //       }
    // }
       ArrayList<Integer>list = new ArrayList<>();
        boolean[]visited = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                printbfs(i,list,adj,visited);
            }
        }
        return list;
    }
    public void printbfs(int i, ArrayList<Integer>list,ArrayList<ArrayList<Integer>> adj, boolean[]visited){
           Queue<Integer> q = new LinkedList<>();
           q.add(i);
           visited[i] = true; 
           while(!q.isEmpty()){
               int front = q.remove();
               list.add(front);
               for(int j=0;j<adj.get(front).size();j++){
                    int neighbor = adj.get(front).get(j);
                    if(!visited[neighbor]){
                        visited[neighbor] = true;
                        q.add(neighbor);
                    }
               }
           }
    }
        
}
