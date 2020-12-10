/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0, num = 0, n = s.length();
        char sign = '+';
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = 0;//归零， 也可以放在此block最后
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i++) -'0';
                }
                i--;
                if (sign == '+') stack.push(num); //遇到数字就运算一次，而不是遇到下一个sign再运算
                if (sign == '-') stack.push(-num);
                if (sign == '*') stack.push(stack.pop() * num);
                if (sign == '/') stack.push(stack.pop() / num);
            } else if (c != ' ') {
                sign = c;
            }
        }
        while(!stack.empty()) {
            res += stack.pop();
        }
        return res;
    }
}
// @lc code=end
