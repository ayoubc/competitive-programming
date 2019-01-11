#include<bits/stdc++.h> 

using namespace std;
typedef long long ll;
const int mod = 1000000007;
ll power(int x,int n){
	if(n==0){
		return 1;
	}
	if(n==1){
		return x%mod;
	}
	ll d = power(x,n/2);
	if(n%2==0){
		return ((d%mod)*(d%mod))%mod;
	}
	else{
		return ((((d%mod)*(d%mod))%mod)*(x%mod))%mod;
	}
}
int main(){
	// freopen("i","r",stdin);
	int n;
	scanf("%d",&n);
	ll ans = power(n,(n-1)*(n-1));
	printf("%lld\n",ans);
} 