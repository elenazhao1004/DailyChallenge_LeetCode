/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 */

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String s : paths) {
            if (s.equals("..")) {
                if (!stack.empty()) stack.pop();
            } else if (!s.equals(".") && !s.equals("")) {
                stack.push(s);
            }
        }

        String res = "";
        while (!stack.empty()) {
            res = "/" + stack.pop() + res;
        }
        if (res.length() == 0) return "/";
        return res;

    }
}
// @lc code=end

