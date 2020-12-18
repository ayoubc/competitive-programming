class Solution {
    public boolean checkValidString(String s) {
        Stack<Pair<Character, Integer>> par = new Stack();
        Stack<Integer> stars = new Stack();
        char[] charArr = s.toCharArray();
        for(int i=0;i<charArr.length; i++) {

            if (charArr[i] == '*') stars.push(i);
            else if(charArr[i] == ')' && (!par.empty() && par.peek().getKey() == '(')) {
                par.pop();

            }
            else par.push(new Pair<>(charArr[i], i));
        }

        while(!par.empty() && !stars.empty()) {
            int index = stars.peek();
            stars.pop();
            Pair<Character, Integer> p = par.peek();

            if ((p.getKey() == ')' && p.getValue() > index) || (p.getKey() == '(' && p.getValue() < index)) {
                par.pop();
            }
        }

        return par.empty();
    }
}