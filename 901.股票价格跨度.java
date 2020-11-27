/*
 * @lc app=leetcode.cn id=901 lang=java
 *
 * [901] 股票价格跨度
 */

// @lc code=start
class StockSpanner {
    Stack<int[]> stack; //Deque<int[]> stack;
    public StockSpanner() {
        stack = new Stack<>(); //stack = new LinkedList<>();
    }
    
    public int next(int price) {
        int res = 1;
        while (!stack.isEmpty() && price >= stack.peek()[0]) {
            res += stack.pop()[1];
        }
        stack.push(new int[]{price, res});
    
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
// @lc code=end

