/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start
//time:O(m*n)
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++){
            dp[i][0] = i; //word1 delete i -> word2
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i; //word1 insert i -> word2
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {//这里index从1开始表示word第一个字母，所以要-1
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                    //replace, insert, delete
                }
            }
        }
        return dp[m][n];
    }
}
// @lc code=end

