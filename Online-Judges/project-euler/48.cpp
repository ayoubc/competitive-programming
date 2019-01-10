#include<iostream>
#include <bits/stdc++.h>
using namespace std;
long long mod_pow(int a,int p,long long mod);
int main(){
	long long sum=0;
	for(int p=1;p<=1000;p++){
		sum = (sum+mod_pow(p,p,10000000000))%10000000000;
		
	}
	//cout<<sum%10000000000<<endl;
	cout<<sum<<endl;
	return 0;
}
int mod_pow(int a,int p,int mod){
	int d;
	if(p==1){
		return a%mod;
	}
	else if(p%2==0){
		d = mod_pow(a,p/2,mod);
		return ((d%mod)*(d%mod))%mo;
	}
	else{
		d = mod_pow(a,(p-1)/2,mod);
		return ((a%mod)*(d%mod)*(d%mod))%mod;
	}
}
