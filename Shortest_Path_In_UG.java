/*You are given an adjacency list, adj of Undirected Graph having unit weight of the edges, find the shortest path from src to all the vertex and if it is unreachable to reach any vertex, then return -1 for that vertex.
Examples :
Input: adj[][] = [[1, 3], [0, 2], [1, 6], [0, 4], [3, 5], [4, 6], [2, 5, 7, 8], [6, 8], [7, 6]], src=0
Output: [0, 1, 2, 1, 2, 3, 3, 4, 4]
Input: adj[][]= [[3], [3], [], [0, 1]], src=3
Output: [1, 1, -1, 0]
Input: adj[][]= [[], [], [], [4], [3], [], []], src=1
Output: [-1, 0, -1, -1, -1, -1, -1] 
Constraint:
1<=adj.size()<=104
0<=edges<=adj.size()-1
*/




class Solution {
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        // code here
        int[]pathvisited = new int[adj.size()];
        for(int i=0;i<pathvisited.length;i++){
            pathvisited[i]=Integer.MAX_VALUE;
        }
        pathvisited[src]=0;
        int[]ans = new int[adj.size()];
        Queue<int[]>q = new LinkedList<>();
        q.add(new int[]{src,0});
        while(!q.isEmpty()){
            int[]cell = q.poll();
            int node = cell[0];
            int distance= cell[1];
            ans[node]=distance;
            for(int i=0;i<adj.get(node).size();i++){
                int neighbour = adj.get(node).get(i);
                if(pathvisited[neighbour]==Integer.MAX_VALUE){
                    pathvisited[neighbour]=distance+1;
                    q.add(new int[]{neighbour,distance+1});
                }
            }
        }
        for(int i=0;i<pathvisited.length;i++){
            if(pathvisited[i]==Integer.MAX_VALUE){
                ans[i]=-1;
            }
        }
        return ans;
    }
}
