#include <bits/stdc++.h>

using namespace std;
const int OO = 1000000000;
int p[25][25],dp[201][21];
int c,m;
int solve(int money,int g){
    if(money<0) return -OO;
    if(g==c) return m - money;
    if(dp[money][g]!=-1) return dp[money][g];
    int ans = -1;
    for(int i=1;i<=p[g][0];i++){
        ans = max(ans,solve(money-p[g][i],g+1));
    }
    return dp[money][g] = ans;
}
int main(){
    //freopen("i.txt","r",stdin);
    int n;
    scanf("%d",&n);
    while(n--){
        memset(dp,-1,sizeof(dp));
        scanf("%d%d",&m,&c);
        for(int i=0;i<c;i++){
            scanf("%d",&p[i][0]);
            for(int j=1;j<=p[i][0];j++) scanf("%d",&p[i][j]);

        }
        int ans = solve(m,0);
        if(ans<0) printf("no solution\n");
        else printf("%d\n",ans);
    }
    return 0;
}
