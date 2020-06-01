class Solution {
    public String removeKdigits(String nums, int k) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<nums.length();i++){
            if(k>0) {
                while(!stack.isEmpty() && stack.peek() > nums.charAt(i) && k>0) {
                    stack.pop();
                    k--;
                }
                stack.push(nums.charAt(i));
            }
            else{
                stack.push(nums.charAt(i));
            }
        }
        String tmp = "";
        String ans = "";

        while (!stack.isEmpty()) {
            tmp += stack.peek();
            stack.pop();
        }
        //System.out.println(k);
        for (int i=tmp.length() - 1;i>=k;i--){
            ans += tmp.charAt(i);
        }
        int i = 0;
        while (i<ans.length() && ans.charAt(i) == '0') i++;

        if(i == ans.length()) ans = "0";
        else ans = ans.substring(i);
        return ans;
    }
    
    
}