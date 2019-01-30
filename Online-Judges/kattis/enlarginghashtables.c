#include <stdlib.h>
#include<stdio.h>
#include<math.h>
typedef long long ll;
int isprime(ll n){
	if(n==2)
		return 1;
	else if(n==1 || n%2==0)
		return 0;
	else{
		ll s = sqrt(n);
		int i;
		for(i=3;i<=s;i+=2){
			if(n%i==0)
				return 0;
		}
		return 1;
	}
}
int main(){
//	freopen("input","r",stdin);
	ll n;
	while(scanf("%lld",&n)==1){
		if(n==0)
			break;
		
		ll p = 2*n+1;
		while(!isprime(p)){
			p += 2;
		}
		printf("%lld",p);
		if(!isprime(n))
			printf(" (%lld is not prime)",n);
		printf("\n");
	}
	return 0;
}

