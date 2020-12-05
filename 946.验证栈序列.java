/*
 * @lc app=leetcode.cn id=946 lang=java
 *
 * [946] 验证栈序列
 */

// @lc code=start
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0; //从popped第一个项开始
        for (int j = 0; j < pushed.length; j++) {
            stack.push(pushed[j]); 
            while (!stack.empty() && popped[i] == stack.peek()) {
                stack.pop();
                i++;
            }
        }
        return stack.empty();
    }
}
// @lc code=end

