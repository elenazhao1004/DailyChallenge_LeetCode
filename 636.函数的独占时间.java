/*
 * @lc app=leetcode.cn id=636 lang=java
 *
 * [636] 函数的独占时间
 */

// @lc code=start
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res= new int[n];
        Stack<Integer> stack = new Stack<>();
        int pre = 0;
        for (String log : logs) {
            String[] arr = log.split(":");
            if (arr[1].equals("start")) {
                if (!stack.empty()) {
                    res[stack.peek()] += Integer.valueOf(arr[2]) - pre; //新start - 旧start
                }
                pre = Integer.valueOf(arr[2]);
                stack.push(Integer.valueOf(arr[0]));
            } else {
                res[stack.pop()] += Integer.valueOf(arr[2]) - pre + 1;//end - start + 1
                pre = Integer.valueOf(arr[2])+ 1; //表示下一段新的start time， 即 end time + 1
            }
        }
        return res;
    }
}

// @lc code=end

