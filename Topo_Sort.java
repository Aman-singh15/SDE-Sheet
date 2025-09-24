/*Given a Directed Acyclic Graph (DAG) of V (0 to V-1) vertices and E edges represented as a 2D list of edges[][], where each entry edges[i] = [u, v] denotes a directed edge u -> v. Return the topological sort for the given graph.
Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u -> v, vertex u comes before v in the ordering.
Note: As there are multiple Topological orders possible, you may return any of them. If your returned Topological sort is correct then the output will be true else false.
Examples:
Input: V = 4, E = 3, edges[][] = [[3, 0], [1, 0], [2, 0]]
Output: true
Explanation: The output true denotes that the order is valid. Few valid Topological orders for the given graph are:
[3, 2, 1, 0]
[1, 2, 3, 0]
[2, 3, 1, 0]
Input: V = 6, E = 6, edges[][] = [[1, 3], [2, 3], [4, 1], [4, 0], [5, 0], [5,2]]
Output: true
Explanation: The output true denotes that the order is valid. Few valid Topological orders for the graph are:
[4, 5, 0, 1, 2, 3]
[5, 2, 4, 0, 1, 3]
*/

// with adjacency matrix

class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        int matrix[][] = new int[V][V];
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v = edges[i][1];
            matrix[u][v]=1;// for directed graph      
        }
        boolean[]visited = new boolean[V];
        Stack<Integer>stack = new Stack<>();
        for(int i=0;i<V;i++){
             if(!visited[i]){
                 dfs(matrix,i,stack,visited);
             }            
        }
          ArrayList<Integer>list = new ArrayList<>();
        int k=0;
        while(!stack.isEmpty()){
           list.add(stack.pop());
        }
        return list;
    }
    public static void dfs(int[][]matrix,int sv,Stack<Integer>stack, boolean[]visited){
            visited[sv]=true;
            for(int i=0;i<matrix.length;i++){
                if(matrix[sv][i]==1 && !visited[i]){
                    dfs(matrix,i,stack,visited);
                }
            }
            stack.push(sv);
    }
}



// with adjacency list


class Solution {
    public int[] topoSort(int V, List<List<Integer>> adj) {
     Stack<Integer>stack = new Stack<>();
     boolean[]visited = new boolean[V];
        for(int i=0;i<V;i++){
             if(!visited[i]){ 
                dfs(adj,i,visited,stack);
             }
        }
        int[]ans = new int[V];
             int k=0;
             while(!stack.isEmpty()){
                 ans[k]=stack.pop();
                 k++;
             }
             return ans;
    }
    public void dfs(List<List<Integer>>adj, int sv, boolean[] visited, Stack<Integer>stack){
        visited[sv]=true;
           for(int i=0;i<adj.get(sv).size();i++){
              int neighbour = adj.get(sv).get(i);
                if(!visited[neighbour]){
                   dfs(adj,neighbour,visited,stack);
                }
           }
           stack.push(sv);
    }
}
