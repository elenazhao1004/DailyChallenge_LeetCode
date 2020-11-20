/*
 * @lc app=leetcode.cn id=712 lang=java
 *
 * [712] 两个字符串的最小ASCII删除和
 */

// @lc code=start
//O(m * n)
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + s1.codePointAt(i -1); //或者 s1.codePointAt(i -1)
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j -1] + s2.charAt(j - 1);
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int a = dp[i - 1][j] + s1.charAt(i - 1);//删除s[i-1]的字符
                    int b = dp[i][j - 1] + s2.charAt(j - 1);//或者删除s[j-1]的字符
                    dp[i][j] = Math.min(a, b);
                }
            }
        }
        return dp[m][n];
    }
}

// @lc code=end

