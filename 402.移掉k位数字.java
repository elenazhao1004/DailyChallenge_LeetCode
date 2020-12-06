/*
 * @lc app=leetcode.cn id=402 lang=java
 *
 * [402] 移掉K位数字
 */

// @lc code=start
class Solution {
    public String removeKdigits(String num, int k) {
        if (k == num.length()) return "0";
        int len = num.length() - k;
        char[] res = new char[len];
        Stack<Character> stack = new Stack<>();
        //num += "0"; //在num最后补一个0， 以防num是一直递增的
        for (int i = 0; i < num.length(); i++) { 
            while (!stack.empty() && num.charAt(i) < stack.peek() && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        //stack.pop(); //删掉在num最后补的一个0
        while (k > 0) {
            stack.pop();
            k--;
        }  
        StringBuilder sb = new StringBuilder();
        while(!stack.empty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        while (sb.length() > 1 && sb.charAt(0) == '0') {//delete leading zeros, 但至少留一个0
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
// @lc code=end

