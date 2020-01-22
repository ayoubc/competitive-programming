#include<bits/stdc++.h>

using namespace std;
typedef long long ll;
const ll mod = 1000000007;
ll dp[5005][5005];
int n,k;
ll power(int x,int p){
	if(p==0){
		return 1;
	}
	ll d = power(x,p/2);
	if(p%2==0){
		return ((d%mod)*(d%mod))%mod;
	}
	else{
		return ((((d%mod)*(d%mod))%mod) * x%mod)%mod; 
	}
}
ll solve(int i,int p)
{
    if(dp[i][p]!=-1) return dp[i][p];
    if(i==0) return dp[i][p] = power(2,n-p);

    dp[i][p] = (p?1LL*p*solve(i-1,p):0)%mod + ((n-p)?1LL*(n-p)*solve(i-1,p+1):0)%mod;
    dp[i][p] %=mod;
    return dp[i][p];

}
int main(){
	// freopen("i","r",stdin);
	ll ans;
	memset(dp,-1,sizeof(dp));
	scanf("%d %d",&n,&k);
	ans = solve(k,0);
	// ans  = power(1,1);
	printf("%I64d\n",ans);
}
