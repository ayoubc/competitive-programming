class StockSpanner {

    private Stack<Pair> st;
    private int index;
    public StockSpanner() {
        this.st = new Stack<>();
        this.index = -1;
    }

    public int next(int price) {
        this.index++;
        while (!this.st.isEmpty() && this.st.peek().getVal() <= price) this.st.pop();
        int x = 0;
        if(this.st.isEmpty()) x = this.index+1;
        else {
            x = this.index - this.st.peek().getIndex();
        }

        this.st.push(new Pair(price, this.index));
        return x;
    }
    
    class Pair {
        private int val;
        private int index;

        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }

        public int getVal() {
            return val;
        }

        public int getIndex() {
            return index;
        }
    }
}


/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */