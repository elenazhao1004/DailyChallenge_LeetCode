

// @lc code=start
class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        char[] arr = expression.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '!' || arr[i] == '|' || arr[i] == '&') {
                operators.push(arr[i]);
            } else if (arr[i] == '(' || arr[i] == 't' || arr[i] == 'f') {
                operands.push(arr[i]);
            } else if (arr[i] == ')') { // 遇到')'就将()里的合并为一个，利用（）前的操作符。
                int trueCount = 0, falseCount = 0;
                while (!operands.empty()) {
                    char pop = operands.pop();
                    if (pop == 't') trueCount++;
                    else if (pop == 'f') falseCount++;
                    else if (pop == '(') break; //只算当前这一对的（）里的数
                }
                char op = operators.pop();
                if (op == '&') {
                    operands.push(falseCount > 0 ? 'f' : 't');//将()里的合并成的一个数再压入栈
                } else if (op == '|') {
                    operands.push(trueCount > 0 ? 't' : 'f');
                } else if (op == '!') {
                    operands.push(trueCount == 0 ? 't' : 'f');
                }
            }
        }
        return operands.pop() == 't' ? true : false;
    }
}

// @lc code=end
