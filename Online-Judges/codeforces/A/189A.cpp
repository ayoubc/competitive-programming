#include <bits/stdc++.h>

using namespace std;
const int OO = 1000000000;
int n;
int pos[3];
int dp[4005];
int solve(int cur){
    if(cur<0) return -OO;
    if(dp[cur]!=-1) return dp[cur];
    if(cur==0) return 0;
    int ans = -OO;
    for(int i=0;i<3;i++){
        ans = max(ans,solve(cur-pos[i])+1);
    }
    return dp[cur] = ans;
}
int main(){
    //freopen("i.txt","r",stdin);
    scanf("%d",&n);
    for(int i=0;i<3;i++) scanf("%d",&pos[i]);
    memset(dp,-1,sizeof(dp));
    int ans = solve(n);
    cout<<ans<<endl;

    return 0;
}
