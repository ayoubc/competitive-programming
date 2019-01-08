#include<bits/stdc++.h>

using namespace std;
const int mod = 1000000007 , N = 200005;
typedef long long ll;
ll f[N],inv[N];
ll power(ll x,ll n){
	if(n==0)
		return 1;
	ll d = power(x,n/2);
	if(n%2==0)
		return ((d%mod)*(d%mod))%mod;
	else
		return (((d%mod)*(d%mod))%mod*x%mod)%mod;

}
ll extendeEuclid(ll a,ll b,ll &x,ll &y){
	ll d,cur;
	if(b==0){
		x = 1;
		y = 0;
		return a;
	}
	d = extendeEuclid(b,a%b,x,y);
	cur = x;
	x = y;
	y = cur - (a/b)*y;
	return d;
}
ll inverse(ll a,ll n){
	ll x,y;
	extendeEuclid(a,n,x,y);
	return (x<0)?x+n:x;
}
void compute(){
	f[0] = 1;
	inv[0] = 1;
	for(int i=1;i<N;i++){
		f[i] = (f[i-1]*i)%mod;
		inv[i] = inverse(f[i],mod);
	}
}
ll nCk(ll n,ll k){
	return (((f[n] * inv[n-k])%mod) * inv[k])%mod;
}
int main(){
	// freopen("i","r",stdin);
	int t;
	ll zero,one,n,Z,O,ans;
	compute();
	scanf("%d",&t);
	string s;
	while(t--){
		cin >> s;
		n = s.size();
		zero = 0;
		one = 0;
		Z = 0;
		O = 0;
		for(int i=0;i<n;i++){
			if(s[i]=='0') zero++;
			else one++;
		}
		for(int i=1;i<=zero;i+=2){
			Z = (Z + nCk(zero,i)) %mod;
			// Z %= mod;
		}
		for(int i=1;i<=one;i+=2){
			O = (O + nCk(one,i)) %mod;
			// O %= mod;
		}
		ans = (power(2,n) - 1 - (Z*O)%mod + mod)%mod;
		// ans = power(2,n) - 1 - Z*O;
		// cout<<nCk(0,1)<<endl;
		// cout<<Z<<" "<<O<<endl;
		printf("%I64d\n",ans);
	}
} 