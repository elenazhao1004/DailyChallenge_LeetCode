

// @lc code=start
class Solution {
    public int calculate(String s) {
        int num = 0, res = 0, curRes = 0, n = s.length();
        char sign = '+';
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (c == '(') {
                int j = i, count = 0;
                for (; i < n; i++) {
                    if (s.charAt(i) == '(') count++;
                    if (s.charAt(i) == ')') count--;
                    if (count == 0) break;
                }
                num = calculate(s.substring(j + 1, i));
            }
            if (c == '+' || c == '-' || c == '*' || c == '/'  || i == n - 1) {
                if (sign == '+') curRes += num;
                if (sign == '-') curRes -= num;
                if (sign == '*') curRes *= num;
                if (sign == '/') curRes /= num;

                if (c == '+' || c == '-' || i == n - 1) {
                    res += curRes;
                    curRes = 0;
                }
                sign = c;
                num = 0;
            }
        }
        return res;
    }
// @lc code=end
