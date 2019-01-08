#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
ll gcd(ll a,ll b){
	if(b==0){
		return a;
	}
	return gcd(b,a%b);
}
ll lcm(ll a,ll b){
	return (a*b)/gcd(a,b);
}
int main(){
	// freopen("i","r",stdin);
	ll a,b,aA = 0,bB = 0,LCM;
	scanf("%I64d %I64d",&a,&b);
	LCM = lcm(a,b);
	// cout<<LCM<<endl;
	aA = LCM/a;
	bB = LCM/b;
	if(aA<bB){
		aA ++;
	}
	else if(aA>bB){
		bB ++;
	}
	string ans;
	if(aA>bB){
		ans = "Dasha";
	}
	else if(aA<bB){
		ans = "Masha";
	}
	else{
		ans = "Equal";
	}
	cout<<ans<<endl;
}