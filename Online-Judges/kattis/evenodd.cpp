#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
const int mod = 1000000007;
ll f(ll x){
	ll cnt = 0;
	while(x!=1){
		cnt++;
		if(x%2==0)
			x/=2;
		else
			x++;
	}
	return cnt;
}
ll g(ll x){
	if(x==1) return 0;
	else if(x%2==0){
		return (x/2 + x + 2*g(x/2) - 2)%mod;
	}
	else{
		return (f(x) + g(x-1))%mod; 
	}
}
int main(){
//	freopen("inp.in","r",stdin);
	ll L,R;
	scanf("%lld %lld",&L,&R);
//	cout<<g(10)<<endl;
	printf("%lld\n",(L==1 ? g(R)%mod:(g(R) - g(L-1)+mod)%mod));
	return 0;
}

