/*
 * @lc app=leetcode.cn id=962 lang=java
 *
 * [962] 最大宽度坡
 */

// @lc code=start
class Solution {
    public int maxWidthRamp(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for (int i = 0; i < A.length; i++) { //只保存最开始那一段单调递增栈
            if (stack.empty() || A[i] < A[stack.peek()]) { //使用单调递增栈(栈顶到栈底递增)来保存坡底的下标
                stack.push(i);
            }
        }

        for (int i = A.length - 1; i >= 0; i--) { //i--更新右边界
            while (!stack.empty() && A[i] >= A[stack.peek()]) { //满足条件 A[left] <= A[right]
                res = Math.max(res, i - stack.pop()); //stack.pop()更新左边界
            }
        }
        return res;
    }
}
// @lc code=end

