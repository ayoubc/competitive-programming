class Solution {
    public boolean backspaceCompare(String S, String T) {
        return solve(S).equals(solve(T));
    }
    
    public String solve(String S) {

        Stack<String> st = new Stack<>();
        for(int i=0;i<S.length();i++) {
            if(S.charAt(i) == '#') {
                if (!st.empty()) st.pop();
            }
            else st.push(S.charAt(i)+"");
        }

        String ans="";
        while (!st.empty()) {
            ans += st.peek();
            st.pop();
        }
        return ans;
    }
}