class Pair{
    int val;
    int span;
    Pair(int val,int span )
    {
        this.val=val;
        this.span=span;
    }
}
class StockSpanner {
     Stack<Pair> stack=new Stack();
    public StockSpanner() {
        
    }
    
    public int next(int price) {
        int c=0;        
        while(!stack.isEmpty() && stack.peek().val<=price)
        {
         c=c+stack.pop().span;
        }

        stack.push(new Pair(price,c+1));
        return ++c;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */