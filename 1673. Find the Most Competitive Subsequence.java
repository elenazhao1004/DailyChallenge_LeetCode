class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[k];
        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
            while (!stack.empty() && nums[i] < stack.peek() && stack.size() + (n - i - 1) >= k) {
                stack.pop();
            }
            if (stack.size() < k) stack.push(nums[i]); //maintain the size of stack
        }
        for (int i = k - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
// @lc code=end
