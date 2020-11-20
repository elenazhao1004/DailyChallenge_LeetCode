/*
 * @lc app=leetcode.cn id=583 lang=java
 *
 * [583] 两个字符串的删除操作
 */

// @lc code=start
//O(m*n)
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;//最长相同子序列又多了一个相同的字符，所以长度加1
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); //取最大值，因为要找最长相同子序列
                }
            }
        }
        return m + n - 2 * dp[m][n];
    }
}
// @lc code=end

