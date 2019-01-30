#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
bool isprime(ll n){
	if(n==2)
		return true;
	else if(n==1 || n%2==0)
		return false;
	else{
		ll s = sqrt(n);
		for(int i=3;i<=s;i+=2){
			if(n%i==0)
				return false;
		}
		return true;
	}
}
int main(){
//	freopen("input","r",stdin);
	ll n;
	while(scanf("%lld",&n)==1){
		if(n==0)
			break;
		bool primen = isprime(n);
		ll p = 2*n+1;
		while(!isprime(p)){
			p += 2;
		}
		printf("%lld",p);
		if(!primen)
			printf(" (%lld is not prime)",n);
		printf("\n");
	}
	return 0;
}

