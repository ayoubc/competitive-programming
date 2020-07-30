class Solution {
public:
    int change(int amount, vector<int>& coins) {
        int n = coins.size();
        vector<vector<int>> ans(n+1, vector<int>(amount+1));
        for(int i=1;i<=amount;i++) ans[0][i] = 0;
        for(int j=0;j<=n;j++) ans[j][0] = 1;
        
        for(int i=1;i<=amount;i++){
            for(int j=1;j<=n;j++){
                if(i - coins[j-1] >= 0){
                    ans[j][i] = ans[j][i - coins[j-1]] + ans[j - 1][i];
                }
                else ans[j][i] = ans[j - 1][i];
            }
        }
        return ans[n][amount];
    }
};