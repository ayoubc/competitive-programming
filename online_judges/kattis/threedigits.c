#include<stdio.h>
#include<stdlib.h>
#include<math.h>

void print3digits(long long n){
	int d[7] = {-1,-1,-1,-1,-1,-1,-1},cnt=0;
	while(n>0){
		d[cnt] = n%10;
		cnt++;
		n /= 10;
	}
	int i;
	for(i=2;i>=0;i--){
		if(d[i]!=-1) printf("%d",d[i]);
	}
}
int main(){ 
	// freopen("i","r",stdin);
	int five=0,two=0;
	long long fac = 1,cur,n,fivepower = 5,mod = 1000000;
	scanf("%lld",&n);
	while(fivepower<=n){
		five += n/fivepower;
		fivepower *= 5;
	}
	// cout<<fivepower<<endl;
	int i;
	for(i=1;i<=n;i++){
		cur = i;
		while(cur%5==0){
			cur /= 5;
		}
		while(cur%2==0 && two<five){
			two++;
			cur /= 2;
		}
		fac *= cur;
		fac %= mod;
	}
	
	// cout<<fac;
	print3digits(fac);
}
