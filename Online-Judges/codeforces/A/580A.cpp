#include <bits/stdc++.h>

using namespace std;
int a[100005];
int dp[100005];
int main()
{
    //freopen("i.txt","r",stdin);
    int n;
    scanf("%d",&n);
    for(int i=0;i<n;i++) scanf("%d",&a[i]);
    dp[0] = 1;
    for(int i=1;i<n;i++){
        if(a[i]>=a[i-1]){
            dp[i] = dp[i-1]+1;
        }
        else dp[i] = 1;
    }
    int ans = 0;
    for(int i=0;i<n;i++) ans = max(ans,dp[i]);
    printf("%d\n",ans);
    return 0;
}
