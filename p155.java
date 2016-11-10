public class MinStack {
    private ArrayList<Integer> stack;
    private ArrayList<Integer> minVal;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayList<>();
        minVal = new ArrayList<>();
    }
    
    public void push(int x) {
        stack.add(x);
        if (minVal.size() == 0 || minVal.get(minVal.size() - 1) >= x)
            minVal.add(x);
    }
    
    public void pop() {
        if (stack.size() > 0 && minVal.size() > 0) {
            if (stack.get(stack.size() - 1).equals(minVal.get(minVal.size() - 1))) {
                minVal.remove(minVal.size() - 1);
            }
            stack.remove(stack.size() - 1);
        }
    }
    
    public int top() {
        return stack.get(stack.size() - 1);
    }
    
    public int getMin() {
        return minVal.get(minVal.size() - 1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
