

// @lc code=start
class Solution {
    public int numberOfSubstrings(String s) {
        int[] count = new int[]{0, 0, 0};
        int left = 0, res = 0, n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i++) {
            count[arr[i] - 'a']++;
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                res += n - i; //找到符合条件的子串时，它右边扩展出来的子串也是符合要求的
                count[arr[left++] - 'a']--;
            }
        }
        return res;
    }
}




// @lc code=end
