class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> ss = new Stack<>();
        Stack<Character> st = new Stack<>();

        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (c == '#'){
                if (!ss.isEmpty()) ss.pop();
            }
            else ss.push(c);
        }

        for(int i=0;i<t.length();i++) {
            char c = t.charAt(i);
            if (c == '#') {
                if (!st.isEmpty()) st.pop();
            }
            else st.push(c);
        }

        if (ss.size() != st.size()) {
            System.out.println(ss.size() + " " + st.size());
            return false;
        }
        while (!ss.isEmpty()) {
            Character cs = ss.pop();
            Character ct = st.pop();
            if (cs != ct) {
                System.out.println(cs + " " + ct);
                return false;
            }
        }
        return true;
    }
}
    