class Solution {
    public int countComponents(int n, int[][] edges) {
       int components =0;
        int[] visited = new int[n];
        
        List<Integer>[] adj = new ArrayList[n];
        for(int i =0;i<n ;i++){
            adj[i] = new ArrayList<Integer>();   
        }
        
        for(int i=0;i<edges.length;i++){
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }
        
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                components++;
                dfs(adj,visited,i);
            }
        }
        
        return components;
    }
    
    private void dfs(List<Integer>[] adj, int[] visited, int startNode){
        visited[startNode]=1;
        
        for(int i=0;i<adj[startNode].size(); i++){
            if(visited[adj[startNode].get(i)]==0){
                dfs(adj, visited, adj[startNode].get(i));
            }
        }
    }
    
}