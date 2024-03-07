/*class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[s1.length()][s2.length()] = true;

        for (int i = dp.length - 1; i >= 0; i--) 
            for ( int j = dp[0].length - 1; j >= 0;j--) {
              //  System.out.println("i: "+i+" j: "+ j);
            if (
                i < s1.length() &&
                s1.charAt(i) == s3.charAt(i + j) &&
                dp[i + 1][j]
            ) {
                dp[i][j] = true;
            }
            if (
                j < s2.length() &&
                s2.charAt(j) == s3.charAt(i + j) &&
                dp[i][j + 1]
            ) {
                dp[i][j] = true;
            }
        }

        return dp[0][0];
    }
}
*/

class Solution {
public boolean isInterleave(String s1, String s2, String s3) {
    char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3.toCharArray();
	int m = s1.length(), n = s2.length();
	if(m + n != s3.length()) return false;
	return dfs(c1, c2, c3, 0, 0, 0, new boolean[m + 1][n + 1]);
}

public boolean dfs(char[] c1, char[] c2, char[] c3, int i, int j, int k, boolean[][] invalid) {
	if(invalid[i][j]) return false;
	if(k == c3.length) return true;
	boolean valid = 
	    i < c1.length && c1[i] == c3[k] && dfs(c1, c2, c3, i + 1, j, k + 1, invalid) || 
        j < c2.length && c2[j] == c3[k] && dfs(c1, c2, c3, i, j + 1, k + 1, invalid);
	if(!valid) invalid[i][j] = true;
    return valid;
}

}