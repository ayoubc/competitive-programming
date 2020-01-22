#include <stdio.h>
#include<stdlib.h>
typedef long long ll;

ll fac(ll x){
	ll sum = 0;
	int i;
	for(i=2;i<=x/i;++i){
		while(x%i==0){
			x = x/i;
			sum = sum + i;
		}
	}
	if(x>1)
		sum = sum + x;
	return sum;
}

int main(){
	ll x,c,pre;
//	freopen("i","r",stdin);
	while(scanf("%lld",&x)==1 && x!=4){
		c = 1;
		pre = fac(x);
		while(pre!=x){
			x = pre;
			pre = fac(x);
			++c;
		}
		printf("%lld %lld\n",x,c);
	}
	return 0;
}

