/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))){
                    num = num * 10 + s.charAt(i++) - '0';
                }
                i--;
                res += sign * num;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0; sign = 1;
            } else if (c == ')') {
                res = res * stack.pop() + stack.pop();
            }
        }
        return res;
    }
}
// @lc code=end
