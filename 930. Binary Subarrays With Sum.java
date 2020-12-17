

// @lc code=start
class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        HashMap<Integer, Integer> map = new HashMap<>();//累加和 -> 出现的次数
        map.put(0 ,1); //curSum-S=0， 说明从开头到当前位置的子数组满足要求
        int sum = 0, res = 0;
        for (int num : A) {
            sum += num;
            res += map.getOrDefault(sum - S, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}


// @lc code=end
