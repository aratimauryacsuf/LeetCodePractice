class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
      HashMap<Integer, List<Integer>> map = new HashMap<>();
      for(int i =0; i < ppid.size(); i++){
          if(ppid.get(i) >0){
              List<Integer> l = map.getOrDefault(ppid.get(i), new ArrayList<Integer>());
              l.add(pid.get(i));
              map.put(ppid.get(i), l);
          }
      }
      Queue<Integer> q = new LinkedList<>();
      List<Integer> l = new ArrayList<>();
      q.add(kill);
      while(!q.isEmpty()){
          int r = q.remove();
          l.add(r);
          if(map.containsKey(r)){
              for(int id : map.get(r))
              q.add(id);
          }

      }
       return l;
    }
}