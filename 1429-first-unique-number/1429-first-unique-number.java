class FirstUnique {
    HashMap<Integer, Boolean> map = new HashMap<>();
    Deque<Integer> q = new ArrayDeque<Integer>();

    public FirstUnique(int[] nums) {
        for(int num : nums){
            this.add(num);
        }
        
    }
    
    public int showFirstUnique() {
        while(!q.isEmpty() && !map.get(q.peek())){
            q.poll();
        }
        return q.isEmpty() ? -1 : q.peek();
        
    }
    
    public void add(int value) {
        if(!map.containsKey(value)){
            map.put(value, true);
            q.add(value);
        }else{
            map.put(value, false);
        }
        
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */