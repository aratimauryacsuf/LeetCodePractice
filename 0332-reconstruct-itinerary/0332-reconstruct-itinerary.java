class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        
        LinkedList<String>  itinerary = new LinkedList<>();
        Map<String , PriorityQueue<String>> graph = new HashMap<>();
        Stack<String> stack = new Stack<>();
        
        for(List<String> ticket: tickets){
            graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>());
            graph.get(ticket.get(0)).add(ticket.get(1));
        }
        
        stack.push("JFK");
        
        while(!stack.isEmpty()){
            String nextDes = stack.peek();
            
            if(! graph.getOrDefault(nextDes, new PriorityQueue<>()).isEmpty()){
                stack.push(graph.get(nextDes).poll());
            }else{
                itinerary.addFirst(stack.pop());
            }
        }
        
        return itinerary;
    }
}