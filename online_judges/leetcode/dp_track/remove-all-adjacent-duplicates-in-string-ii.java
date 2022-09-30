class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<String> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (stack.isEmpty()) stack.add(""+c);
            else {
                String cur = stack.pop();
                if (cur.charAt(0) == c) {
                    cur += c;
                    if (cur.length() != k) stack.push(cur);
                }
                else {
                    stack.push(cur);
                    stack.push(c+"");
                }
            }
        }

        String ans = "";
        for (Object o: stack.toArray()) ans += o.toString();
        return ans;
    }
}
