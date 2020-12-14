

// @lc code=start
class Solution {
    public NestedInteger deserialize(String s) {
        if (s == null || s.length() == 0) return null;
        if (s.charAt(0) != '[') return new NestedInteger(Integer.parseInt(s));//或者Integer.valueOf(s)
        if (s.length() <= 2) return new NestedInteger();
        Stack<NestedInteger> stack = new Stack<>();
        int num = 0, sign = 1, n = s.length();

        for (int i = 0; i < n; i++){
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                while ( i < n && Character.isDigit(s.charAt(i))){
                    num = num * 10 + sign * (s.charAt(i++) - '0');
                }
                i--;
                stack.push(new NestedInteger(num));//将之前累加的数字放入栈顶元素
                num = 0;
                sign = 1;
            } else if (c == '-'){
                sign = -1;
            } else if (c == '['){
                stack.push(new NestedInteger()); //新元素开始
            } else if (c == ',' || c == ']'){ //将single Integer放入新建的空的[]， 或是将里面[]放入外面一层[]
                if (i >= 1 && s.charAt(i - 1) == '[') continue; //如果是[], 里面没有single Integer，就不用放
                NestedInteger top = stack.pop(); //结束栈顶元素,放入上一个元素的列表中
                stack.peek().add(top);
            }
        }return stack.pop();
    }
}

// @lc code=end
