class Twitter {
   int count;
    HashMap<Integer, List<int[]>> tweetMap ;
    HashMap<Integer, HashSet<Integer>> followMap;
    
    public Twitter() {
     count =0;
    tweetMap = new HashMap<>();
    followMap = new HashMap<>();
        
    }
    
    public void postTweet(int userId, int tweetId) {
       if(!tweetMap.containsKey(userId))
           tweetMap.put(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[]{count,tweetId} );
        count++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(b[0],a[0]));
        
        if (!followMap.containsKey(userId)) 
            followMap.put(userId, new HashSet<>());
        followMap.get(userId).add(userId);
    
            Set<Integer> followees = followMap.get(userId);
             
        
        for(int followeeId: followees){
            if(tweetMap.containsKey(followeeId)){
                List<int[]> followeeTweets = tweetMap.get(followeeId);
                int size = followeeTweets.size();
                System.out.println("in getfeed  no of tweet"+ size);
                if (size > 0) {
                    int[] tweet = followeeTweets.get(size - 1);
                    pq.offer(new int[]{tweet[0], tweet[1], followeeId, size - 1});
                }
            
            }
        }
        
        while(!pq.isEmpty() && res.size() <10){
            int[] data = pq.poll();
            System.out.println("count:"+ data[0]+ " tweetid"+ data[1]);
            res.add(data[1]);
            
            int followeeId = data[2];
            int tweetIndex = data[3];
            
            if(tweetIndex >0){
                int[] tweet = tweetMap.get(followeeId).get(tweetIndex-1);
                System.out.println("in tweetindex:"+ tweet[0] +" ID:"+ tweet[1]);
                 pq.offer(new int[]{tweet[0], tweet[1], followeeId, tweetIndex - 1});
            }
        }
        
        return res;
        
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followMap.containsKey(followerId))
            followMap.put(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
        
            
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)){
            HashSet<Integer> set=  followMap.get(followerId);
            if(set.contains(followeeId))
            followMap.get(followerId).remove(followeeId);
        }
           
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */