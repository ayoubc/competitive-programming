#include <bits/stdc++.h>

using namespace std;
const int H = 101,W = 101;
int dp[H][W],g[H][W];
int main(){
    //freopen("i.txt","r",stdin);
    int h,w,t;
    scanf("%d",&t);
    while(t--){
        scanf("%d%d",&h,&w);
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++)scanf("%d",&g[i][j]);
        }
        memset(dp,0,sizeof(dp));
        for(int i=0;i<w;i++) dp[0][i] = g[0][i];
        for(int i=1;i<h;i++){
            for(int j=1;j<w-1;j++){
                dp[i][j] = g[i][j] + max(dp[i-1][j+1],max(dp[i-1][j-1],dp[i-1][j]));
            }
            dp[i][0] = g[i][0] + max(dp[i-1][0],(w>=2 ? dp[i-1][1]:0));
            dp[i][w-1] = g[i][w-1] + max(dp[i-1][w-1],(w>=2 ? dp[i-1][w-2]:0));
        }
        int ans=0;
        for(int i=0;i<w;i++) ans = max(ans,dp[h-1][i]);
        cout<<ans<<endl;
    }
    return 0;
}
