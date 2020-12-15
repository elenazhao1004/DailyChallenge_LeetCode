

// @lc code=start
class Solution {
    public List<String> braceExpansionII(String expression) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isLetter(c)) {
                sb.append("{");
                sb.append(c);
                sb.append('}');
            } else {
                sb.append(c);
            }
        }

        Stack<Character> operators = new Stack<>();
        Stack<List<String>> operands = new Stack<>();
        List<String> cur = new ArrayList<>();

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (Character.isLetter(c)) { //将cur的值赋值为这个字符串
                StringBuilder word = new StringBuilder();
                while (i < sb.length() && Character.isLetter(sb.charAt(i))) {
                    word.append(sb.charAt(i++));
                }
                i--;
                cur.add(word.toString());
            } else if (c == '{') { //压入
                operands.push(cur); // 将{之前的值压入stack
                operators.push('{');
                cur = new ArrayList<>();
            } else if (c == ',') { //压入
                operands.push(cur);
                operators.push(',');
                cur = new ArrayList<>();
            } else if (c == '}') { //遇到“}”,1.处理{}里的","(并集操作) 2.处理在{}之前的cur值，(点乘操作)
                while (operators.peek() == ',') { //⚠️如果有多个","这些（并集操作）要连续地进行
                    cur = combine(operands.pop(), cur); //⚠️输出有顺序，新加入的字母放后面
                    operators.pop();
                }
                if (operators.peek() == '{') { //处理完","之后，再执行（点乘操作），处理在{}之前的cur值
                    cur = crossProduct(operands.pop(), cur);
                    operators.pop();
                }
            }
        }
        //Collections.sort(cur);
        //return cur.stream().distinct().collect(Collectors.toList());
        TreeSet<String> set = new TreeSet<>(cur); //⚠️不能用HashSet,无序的。输出要求有序
        return new ArrayList<>(set);

    }

    private List<String> combine(List<String> pre, List<String> cur) {
        List<String> res = new ArrayList<>();
        for (String s : pre) res.add(s);
        for (String s : cur) res.add(s);
        return res;
    }
    private List<String> crossProduct(List<String> pre, List<String> cur) {
        List<String> res = new ArrayList<>();
        if (pre.size() == 0) pre.add("");
        if (cur.size() == 0) cur.add("");
        for (String s1 : pre) {
            for (String s2 : cur) {
                res.add(s1 + s2);
            }
        }
        return res;
    }
}



// @lc code=end
