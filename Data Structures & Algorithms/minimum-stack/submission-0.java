class MinStack {
     Stack<Integer>st;
     Stack<Integer> minSt;
    public MinStack() {
        st=new Stack<>();
        minSt=new Stack<>();

    }
    
    public void push(int val) {
        st.push(val);
        if(minSt.isEmpty()){
            minSt.push(val);
        }else{
            minSt.push(Math.min(minSt.peek(),val));
        }
    }
    
    public void pop() {
        if(!st.isEmpty())
        st.pop();
        minSt.pop();
    }
    
    public int top() {
        
        return st.peek();
    }
    
    public int getMin() {
    
        return minSt.peek();
    }
}
