/*
 * @lc app=leetcode.cn id=907 lang=java
 *
 * [907] 子数组的最小值之和
 */

// @lc code=start
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        //dp[i] 表示以数字 A[i - 1] 结尾的所有子数组最小值之和
        int[] dp = new int[n + 1]; //dp[0]表示在找前小数字时，j<0时的累加和 
        Stack<Integer> stack = new Stack<>(); //压入的index
        stack.push(-1);// 以防在找前小数字时，j<0时
        int M = (int)1e9 + 7;
        int res = 0;

        for (int i = 0; i < n; i++) {
            while (stack.peek() != -1 && arr[stack.peek()] >= arr[i]) { //向前找第一个小于当前的数字
                stack.pop();
            }
            dp[i + 1] = (dp[stack.peek() + 1] + (i - stack.peek()) * arr[i]) % M;//防止中途越界， optional
            stack.push(i);
            res = (res + dp[i + 1]) % M;
        }
        return res;
    }
}
// @lc code=end

