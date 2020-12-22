

// @lc code=start
//先计算最长和为sum-x的子数组长度，res = n - maxLen;
class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int num : nums) sum += num;
        int target = sum - x;
        int n = nums.length, maxLen = Integer.MIN_VALUE;
        if (target == 0) return n;
        if (target < 0) return -1; //⚠️一定要加
        HashMap<Integer, Integer> map = new HashMap<>();//前缀和->其坐标
        sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            map.put(sum, i);
        }
        if (map.containsKey(target)) { //或者map.put(0, -1);
            maxLen = map.get(target) + 1;
        }
        sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (map.containsKey(sum - target)) {
                int len = i - map.get(sum - target);
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen == Integer.MIN_VALUE ? -1 : n - maxLen;
    }
}





// @lc code=end
