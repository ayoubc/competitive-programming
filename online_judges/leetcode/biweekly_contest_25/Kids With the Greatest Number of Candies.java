class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();
        for(int i=0;i<candies.length;i++) {
            int x = candies[i] +  extraCandies;
            boolean ok = true;
            for(int j=0;j<candies.length;j++) {
                if (x<candies[j]) ok = false;
            }
            ans.add(ok);
            
        }
        return ans;
    }
}