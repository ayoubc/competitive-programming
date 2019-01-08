#include <bits/stdc++.h>
using namespace std;
const int NMAX = 100005, MOD = 1000000007;
typedef long long ll;
//in this problem it is hard to compute the combinatorics coefficient because there is a constarint of memory.
ll f[NMAX] , inv[NMAX];
ll extendedEuclid(ll a ,ll b ,ll &x,ll &y){
	ll t,d;
	if(b==0){
		x = 1;
		y = 0;
		return a;
	}
	d = extendedEuclid(b,a%b,x,y);
	t = x;
	x = y;
	y = t - (a/b)*y;
	return d;
}
ll inverse(ll a,ll n){
	ll x,y;
	extendedEuclid(a,n,x,y);
	return (x<0)?(x+n):x;
}

void compute(){
	f[0] = 1;
	inv[0] = 1;
	for(int i=1;i<=NMAX;i++){
		f[i] = (i*f[i-1])%MOD;
		inv[i] = inverse(f[i],MOD);	
	}
}
ll C(int n,int k){
	ll ans = (((f[n] * inv[k])%MOD) * inv[n-k]) % MOD;
	return ans;
}
int main(){
//	freopen("i","r",stdin);
	ios_base::sync_with_stdio(false);
	int n;
//	cin >> n;
	scanf("%d",&n);
	ll ans = 0;
	compute();
	for(int k=1;k<=n;k++){
		ans += ( C(n,k) * C(n-1,k-1) ) % MOD;
		ans %= MOD;
	}
	ans = (2*ans - n + MOD) % MOD;
//	cout<<ans<<endl;
	printf("%I64d\n",ans);
	return 0;
}

