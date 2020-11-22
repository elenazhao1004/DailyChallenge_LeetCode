/*
 * @lc app=leetcode.cn id=1458 lang=java
 *
 * [1458] 两个子序列的最大点积
 */

// @lc code=start
class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = nums1[i] * nums2[j];
                //dp[i][j]的最大值分为三种情况
                if (i > 0 && j > 0) { //1.包含i,j (先判断这个情况！！), 因为dp[i - 1][j - 1]有可能是负数，如果为正数就加，负数不加
                    dp[i][j] += Math.max(dp[i - 1][j - 1], 0);
                }
                if (i > 0) { // 2.不包含i, dp[i-1][j], 和上边最大值比较
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                }
                if (j > 0) { // 3.不包含j dp[i][j-1]， 和左边最大值比较
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
                }
                
            }
        }
        return dp[m - 1][n - 1];
    }
}
// @lc code=end

