class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        for(int i=0;i<target.length;i++){
            int b = target[i];
            int a = i>0 ? target[i-1] : 0;
            for(int j=a+1;j<b;j++){
                if (!checkIfExist(target, j)){
                    ans.add("Push");
                    ans.add("Pop");
                }
            }
            ans.add("Push");
        }
        return ans;
    }
    
    public boolean checkIfExist(int[] target, int n) {
        for(int i=0;i<target.length;i++) {
            if(target[i] == n){
                return true;
            }
        }
        return false;
    }
}