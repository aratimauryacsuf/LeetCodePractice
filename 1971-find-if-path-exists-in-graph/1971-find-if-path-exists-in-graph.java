class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
       Map<Integer, List<Integer>> graph = new HashMap<>();
        
    for(int i=0; i<n ;i++){
        graph.put(i, new ArrayList<>());
    }
        
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> q = new LinkedList();
        Set<Integer> set = new HashSet<>();
        
        q.add(source);
        set.add(source);
        
        while(!q.isEmpty()){
            int vertex = q.poll();
            if(vertex == destination ){
                return true;
            }
            
            List<Integer> neigh = graph.get(vertex);
            
            for(int nei : neigh){
                if(!set.contains(nei)){
                if(nei == destination ){
                    return true;
                }
                q.add(nei);
                set.add(nei);
            }
            }
        }
        
       return false; 
    }
}