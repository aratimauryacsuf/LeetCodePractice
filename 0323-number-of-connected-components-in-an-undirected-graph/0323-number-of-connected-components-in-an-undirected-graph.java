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

/*  Approach 2: Disjoint Set Union (DSU)
public class Solution {

    private int find(int[] representative, int vertex) {
        if (vertex == representative[vertex]) {
            return vertex;
        }
        
        return representative[vertex] = find(representative, representative[vertex]);
    }
    
    private int combine(int[] representative, int[] size, int vertex1, int vertex2) {
        vertex1 = find(representative, vertex1);
        vertex2 = find(representative, vertex2);
        
        if (vertex1 == vertex2) {
            return 0;
        } else {
            if (size[vertex1] > size[vertex2]) {
                size[vertex1] += size[vertex2];
                representative[vertex2] = vertex1;
            } else {
                size[vertex2] += size[vertex1];
                representative[vertex1] = vertex2;
            }
            return 1;
        }
    }

    public int countComponents(int n, int[][] edges) {
        int[] representative = new int[n];
        int[] size = new int[n];
        
        for (int i = 0; i < n; i++) {
            representative[i] = i;
            size[i] = 1;
        }
        
        int components = n;
        for (int i = 0; i < edges.length; i++) { 
            components -= combine(representative, size, edges[i][0], edges[i][1]);
        }

        return components;
    }
}
*/