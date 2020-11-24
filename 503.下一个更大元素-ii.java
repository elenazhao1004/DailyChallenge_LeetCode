/*
 * @lc app=leetcode.cn id=503 lang=java
 *
 * [503] 下一个更大元素 II
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();   // 存储的是索引index
        
        for(int i = 0; i < 2 * n; i++) {
            while(!stack.empty() && nums[stack.peek()] < nums[i % n]){
                res[stack.pop()] = nums[i % n]; //建立映射， index -> 其右边第一个较大值
            } 
            if (i < n) stack.push(i); //超过n的部分我们只是为了给之前栈中的数字找较大值，所以不能压入栈
        }  
        return res;
    }
}
// @lc code=end

