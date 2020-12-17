

// @lc code=start
class Solution {
    public int longestOnes(int[] A, int K) {
        int left = 0,count = 0, i;
        //i即窗口的right
        for(i = 0; i < A.length;i++){
            if(A[i] == 0) count++;
            if(count > K){
                if(A[left++] == 0) count--;
            }
        }
        return i - left;
    }
}




// @lc code=end
