

// @lc code=start
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n + 1];//下标是前缀和（即当前奇数的个数），值是前缀和的个数。
        prefix[0] = 1; //奇数个数为0的，有1个
        int oddCnt = 0, res = 0;
        for (int num : nums) {
            if ((num & 1) == 1) oddCnt++; // oddCnt += num & 1; 也可以
            prefix[oddCnt]++; //奇数个数为oddCnt的，有几个
            if (oddCnt >= k) {
                res += prefix[oddCnt - k];
            }
        }
        return res;
    }
}





// @lc code=end
