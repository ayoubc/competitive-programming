#include<iostream>
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

ll fac(ll x){
	ll sum = 0;
	for(int i=2;i<=x/i;i++){
		while(x%i==0){
			x/=i;
			sum += i;
		}
	}
	if(x>1)
		sum += x;
	return sum;
}
//ll sumprime(vector<ll> v){
//	ll x = 0;
//	for(int i=0;i<v.size();i++){
//		x += v[i];
//	}
//	return x;
//}
int main(){
	ll x,c,pre;
//	freopen("i","r",stdin);
	while(scanf("%lld",&x)==1 and x!=4){
		c = 1;
//		vector<ll> v = fac(x);
		pre = fac(x);
		while(pre!=x){
			
			x = pre;
			pre = fac(x);
//			v = fac(x);
			c++;
		}
		printf("%lld %lld\n",x,c);
	}
	return 0;
}

