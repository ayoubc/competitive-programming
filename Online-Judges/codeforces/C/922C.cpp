#include<bits/stdc++.h> 
#include <ctime>
using namespace std;
clock_t start, end;
typedef long long ll;
bool ok(ll n, ll k){
	ll cur = n,bin,X;
	int  x = 0;
	while(cur){
		cur /= 2;
		x++;
	}
	bin = 1<<x;
	X = n/bin;
	return X<=k;
}
int main(){
	// freopen("i","r",stdin);
	ll n,k;
	// start  = clock();
	scanf("%I64d%I64d",&n,&k);
	set<ll> s;
	for(int i=1;i<=k;i++){
		if(s.count(n%i)){
			puts("No");
			return 0;
		}
		s.insert(n%i);
	}
	puts("Yes");
	// end = clock();
	// cerr<<"time: "<<end - start<<" ms"<<endl;
	return 0;
}