class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        Set<Integer> leftSet = new HashSet<>(); // diag \ row - col
        Set<Integer> rightSet = new HashSet<>(); // diag / row + col
        Set<Integer> colSet = new HashSet<>(); // column | col
        dfs(n, result, cur, leftSet, rightSet, colSet);
        return result;
    }

    private void dfs(int n, List<List<String>> result, List<String> cur, Set<Integer> leftSet,
            Set<Integer> rightSet, Set<Integer> colSet) {
        
        //System.out.println("CurrentList size: "+ cur.size());
        if (cur.size() == n) {
            result.add(new ArrayList(cur));
            return;
        }
        int row = cur.size();
        // i is column index
        for (int i = 0; i < n; i++) {
            //System.out.println("row: "+ row + " i: "+ i);
            if (leftSet.contains(row - i) || rightSet.contains(row + i) || colSet.contains(i)) {
                 //System.out.println("In side IF condition row: "+ row + " i: "+ i);
                continue;
            }
            // current col index is added to the solution list cur
            cur.add(convert(n, i));
            leftSet.add(row - i);
            rightSet.add(row + i);
            colSet.add(i);
            // go to dfs next level
            dfs(n, result, cur, leftSet, rightSet, colSet);
            // backtracking
            cur.remove(cur.size() - 1);
           //  System.out.println("CurrentList size after removal: "+ cur.size());
            leftSet.remove(row - i);
            rightSet.remove(row + i);
            colSet.remove(i);

        }
    }

    private String convert(int n, int col) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == col) {
                res.append("Q");
            } else {
                res.append(".");
            }
        }
        // System.out.println("Col: " + col);
        //System.out.println("res in covert method:" + res.toString());
        return res.toString();
    }
}