class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length];
        
        for(int i= 0; i< edges.length; i++){
            parent[i] = i+1;
        }
        
        for(int[] edge : edges){
            if(findParent(edge[0])== findParent(edge[1]))
                return edge;
            else
                unionParent(edge[0], edge[1]);
        }
        return new int[2];
    }
    
    public int findParent(int x){
        if(x == parent[x-1]) return x;
        return findParent(parent[x-1]);
    }
    
    public void unionParent(int x, int y){
        parent[findParent(y)-1] = findParent(x);
    }
}