#include<bits/stdc++.h>

using namespace std;
typedef long long ll;
void print3digits(ll n){
	vector<int> d;
	while(n){
		d.push_back(n%10);
		n /= 10;
	}
	for(int i=min((int)d.size()-1,2);i>=0;i--)
		printf("%d",d[i]);
}
int main(){ 
	// freopen("i","r",stdin);
	int five=0,two=0;
	ll fac = 1,cur,n,fivepower = 5,mod = 1000000;
	scanf("%lld",&n);
	while(fivepower<=n){
		five += n/fivepower;
		fivepower *= 5;
	}
	// cout<<fivepower<<endl;
	for(ll i=1;i<=n;i++){
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
