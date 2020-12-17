

// @lc code=start
class Solution {
    public String countOfAtoms(String formula) {
        String res = "";
        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> pre = new TreeMap<>();
        Map<String, Integer> cur = new TreeMap<>();
        char[] arr = formula.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (Character.isLetter(c)) {
                StringBuilder elem = new StringBuilder();
                elem.append(arr[i++]);
                while (i < arr.length && Character.isLowerCase(arr[i])) {
                    elem.append(arr[i++]);
                }
                StringBuilder cnt = new StringBuilder();
                while (i < arr.length && Character.isDigit(arr[i])){
                    cnt.append(arr[i++]);
                }
                i--;
                String key = elem.toString();
                int value = cnt.length() == 0 ? 1 : Integer.valueOf(cnt.toString());
                cur.put(key, cur.getOrDefault(key, 0) + value);
            } else if (c == '(') {
                stack.push(cur);
                cur = new TreeMap<>(); //清空cur
            } else if (c == ')') {
                i++;
                StringBuilder multiple = new StringBuilder();
                while (i < arr.length && Character.isDigit(arr[i])) {
                    multiple.append(arr[i++]);
                }
                i--;
                int mul = multiple.length() == 0 ? 1 : Integer.valueOf(multiple.toString());
                pre = stack.pop(); //放在for loop外面
                for (Map.Entry<String, Integer> entry : cur.entrySet()) {
                    String key = entry.getKey();
                    int value = entry.getValue() * mul;
                    pre.put(key, pre.getOrDefault(key, 0) + value); //将（）里的和（）前面的，同一级的元素相加
                    cur = pre;
                }
            }
        }

        for (Map.Entry<String, Integer> entry : cur.entrySet()) {
            res += entry.getKey() + (entry.getValue() == 1 ? "" : entry.getValue());
        }
        return res;
    }
}



// @lc code=end
