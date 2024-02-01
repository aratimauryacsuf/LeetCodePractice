class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        
        for(int i =0; i< numCourses ;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] prereq: prerequisites){
            adj.get(prereq[1]).add(prereq[0]);
            indegree[prereq[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i< numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        
        int nodeVisited =0;
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            nodeVisited++;
            
            for(int pre: adj.get(node)){
                indegree[pre]--;
                if(indegree[pre]==0){
                    queue.offer(pre);
                }
            }
            
        }
        
        return nodeVisited == numCourses;
    }
}