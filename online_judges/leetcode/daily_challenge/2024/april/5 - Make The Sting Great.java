class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        for (char c:s.toCharArray()) {
            if (st.isEmpty()) {
                st.push(c);
            }
            else {
                char x = st.peek();
                if (isBad(c, x)) {
                    st.pop();
                }
                else st.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
    private boolean isBad(char c1, char c2) {
        if ('a'<=c1 && c1<='z' && 'A'<=c2 && c2<='Z') {
            return c1 - 'a' == c2 - 'A';
        }
        if ('a'<=c2 && c2<='z' && 'A'<=c1 && c1<='Z') {
            return c2 - 'a' == c1 - 'A';
        }
        return false;
    }
}