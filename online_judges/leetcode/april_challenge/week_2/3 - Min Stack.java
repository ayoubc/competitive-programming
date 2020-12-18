class MinStack {
    private Stack<Pair<Integer, Integer>> stack;
    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new Stack<Pair<Integer, Integer>>();
    }
    
    public void push(int x) {
        Pair<Integer, Integer> p;
        if(this.stack.empty()){
            p = new Pair<Integer, Integer>(x, x);
        }
        else {
            int m = Math.min(x, this.stack.peek().getValue());
            p = new Pair<Integer, Integer>(x, m);
        }
        this.stack.push(p);
    }
    
    public void pop() {
        this.stack.pop();
    }
    
    public int top() {
        return this.stack.peek().getKey();
    }
    
    public int getMin() {
        return this.stack.peek().getValue();
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