#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
vector<ll> fac(ll n){
	vector<ll> v;
	for(ll i=2;i<=n/i;i++){			
		while(n%i==0){
			v.push_back(i);
			n/=i;
		}
	}
	if(n>1)
		v.push_back(n);
	return v;
}
int main(){
//	freopen("i","r",stdin);
	ll n;
	while(scanf("%lld",&n)==1){
		if(n==0)
			break;
		
		vector<ll> v = fac(n);
//		if(v.siz)
		/*for(int i=0;i<v.size();i++){
			printf("%d ",v[i]);
		}
		printf("\n");*/
		ll p = 2*n+1;
		while(fac(p).size()!=1){
			p += 2;
		}
		printf("%lld",p);
		if(v.size()!=1)
			printf(" (%lld is not prime)",n);
		printf("\n");
	}
	return 0;
}

