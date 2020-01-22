#include<iostream>
#include <bits/stdc++.h>
using namespace std;
//sum of prime numbers below 2000000
int main(){
	long n = 2000000;
	bool primes[n+1];
	memset(primes,true,sizeof(primes));
	for(int p=2;p*p<=n;p++){
		if(primes[p]){
			for(int i=2*p;i<=n;i+=p){
				primes[i] = false;
			}
		}
	}
	long long some=0;
	for(int d=2;d<=n;d++){
		if(primes[d]){
			some+=d;
		}
	}
	printf("%lld\n",some);
	return 0;
}

