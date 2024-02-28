class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i =0; i <n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
        }
        return dfs(adjList, source, destination, new Boolean[n]);
    }

    public boolean dfs(List<List<Integer>> adjList,int node, int destination, Boolean[] state ){
        if(state[node] != null){
            return state[node];
        }
        if(adjList.get(node).isEmpty()){
            return node == destination;
        }
        state[node] = false;
        for(int nei : adjList.get(node)){
            if(!dfs(adjList, nei, destination, state)){
                return false;
            }
        }
        state[node] = true;
        return true;

    }
}