class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];

            if (!token.equals("+") && !token.equals("-") && !token.equals("*")
                && !token.equals("/")) {
                st.push(Integer.parseInt(token));
            } else {
                int b = st.pop();
                int a = st.pop();

                if (token.equals("+")) {
                    st.push(a + b);
                } else if (token.equals("-")) {
                    st.push(a - b);
                } else if (token.equals("*")) {
                    st.push(a * b);
                } else {
                    st.push(a / b);
                }
            }
        }
        return st.peek();
    }
}
// demand:- string de rakha hai usmai arithmetic expression hai , and number hai , ham ko result
// retun karna hoga strongets signal:-Return the integer that represents the evaluation of the
// expression. brutforce:- kuch soch nehi pa rah hnu
//  why stack :- jitta ,,mujhe samjh arha hai sare letter ko push karte jao , and jab bhi artihmetic
//  expression aye tabh top k 2 latter ko uthao and uske bad expression karo and resultt nam ka
//  store karke rakho