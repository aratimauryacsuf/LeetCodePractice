//Union-find
class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
	
		// create <time, index> map
        Map<Integer, List<Integer>> timeToIndexes = new TreeMap<>();
        int m = meetings.length;
        for (int i = 0; i < m; i++) {
            timeToIndexes.putIfAbsent(meetings[i][2], new ArrayList<>());
            timeToIndexes.get(meetings[i][2]).add(i);
        }
		
        UF uf = new UF(n);
		// base
        uf.union(0, firstPerson);
		
		// for every time we have a pool of people that talk to each other
		// if someone knows a secret proir to this meeting - all pool will too
		// if not - reset unions from this pool
        for (int time : timeToIndexes.keySet()) {
            Set<Integer> pool = new HashSet<>();
			
            for (int ind : timeToIndexes.get(time)) {
                int[] currentMeeting = meetings[ind];
                uf.union(currentMeeting[0], currentMeeting[1]);
                pool.add(currentMeeting[0]);
                pool.add(currentMeeting[1]);
            }
			
			// meeting that took place now should't affect future
			// meetings if people don't know the secret
            for (int i : pool) if (!uf.connected(0, i)) uf.reset(i);
        }
		
		// if the person is conneted to 0 - they know a secret
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) if (uf.connected(i,0)) ans.add(i);
        return ans;
    }
    
	// regular union find
    private static class UF {
        int[] parent, rank;
		
        public UF(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ)
                return;

            if (rank[rootP] < rank[rootQ]) {
                parent[rootP] = rootQ;
            } else {
                parent[rootQ] = rootP;
                rank[rootP]++;
            }
        }
        
        public int find(int p) {
            while (parent[p] != p) {
                p = parent[parent[p]];
            }
            return p;
        }
        
        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }
        
        public void reset(int p) {
            parent[p] = p;
            rank[p] = 0;
        }
    }
}

/* BFS
class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        // For every person, we store the meeting time and label of the person met.
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] meeting : meetings) {
            int x = meeting[0], y = meeting[1], t = meeting[2];
            graph.computeIfAbsent(x, k -> new ArrayList<>()).add(new int[]{t, y});
            graph.computeIfAbsent(y, k -> new ArrayList<>()).add(new int[]{t, x});
        }

        // Earliest time at which a person learned the secret 
        // as per current state of knowledge. If due to some new information, 
        // the earliest time of knowing the secret changes, we will update it
        // and again process all the people whom he/she meets after the time
        // at which he/she learned the secret.
        int[] earliest = new int[n];
        Arrays.fill(earliest, Integer.MAX_VALUE);
        earliest[0] = 0;
        earliest[firstPerson] = 0;
        
        // Queue for BFS. It will store (person, time of knowing the secret)
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        q.offer(new int[]{firstPerson, 0});

        // Do BFS
        while (!q.isEmpty()) {
            int[] personTime = q.poll();
            int person = personTime[0], time = personTime[1];
            for (int[] nextPersonTime : graph.getOrDefault(person, new ArrayList<>())) {
                int t = nextPersonTime[0], nextPerson = nextPersonTime[1];
                if (t >= time && earliest[nextPerson] > t) {
                    earliest[nextPerson] = t;
                    q.offer(new int[]{nextPerson, t});
                }
            }
        }
        
        // Since we visited only those people who know the secret,
        // we need to return indices of all visited people.
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (earliest[i] != Integer.MAX_VALUE) {
                ans.add(i);
            }
        }
        return ans;
    }
} */

/*
class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        // For every person, we store the meeting time and label of the person met.
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] meeting : meetings) {
            int x = meeting[0], y = meeting[1], t = meeting[2];
            graph.computeIfAbsent(x, k -> new ArrayList<>()).add(new int[]{t, y});
            graph.computeIfAbsent(y, k -> new ArrayList<>()).add(new int[]{t, x});
        }
        
        // Earliest time at which a person learned the secret 
        // as per current state of knowledge. If due to some new information, 
        // the earliest time of knowing the secret changes, we will update it
        // and again process all the people whom he/she meets after the time
        // at which he/she learned the secret.
        int[] earliest = new int[n];
        Arrays.fill(earliest, Integer.MAX_VALUE);
        earliest[0] = 0;
        earliest[firstPerson] = 0;

        // Stack for DFS. It will store (person, time of knowing the secret)
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, 0});
        stack.push(new int[]{firstPerson, 0});

        // Do DFS
        while (!stack.isEmpty()) {
            int[] personTime = stack.pop();
            int person = personTime[0], time = personTime[1];
            for (int[] nextPersonTime : graph.getOrDefault(person, new ArrayList<>())) {
                int t = nextPersonTime[0], nextPerson = nextPersonTime[1];
                if (t >= time && earliest[nextPerson] > t) {
                    earliest[nextPerson] = t;
                    stack.push(new int[]{nextPerson, t});
                }
            }
        }
        
        // Since we visited only those people who know the secret
        // we need to return indices of all visited people.
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (earliest[i] != Integer.MAX_VALUE) {
                ans.add(i);
            }
        }
        return ans;
    }
}
*/