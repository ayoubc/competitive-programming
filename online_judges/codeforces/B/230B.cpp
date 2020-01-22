#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
const int N = 1000005;
bool isperfect(ll x){
	ll s = sqrt(x);
	return x == s*s;
}
bool prime[N];
void  seive(){
	memset(prime,true,sizeof(prime));
	for(int i=2;i<=N;i++){
		if(prime[i]){
			for(int j=2*i;j<=N;j+=i){
				prime[j] = false;
			}
		}
	}
}
int main(){
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	seive();
	int n;
	cin>>n;
	ll a[n];
	for(int i=0;i<n;i++){
		cin>>a[i];
		
	}
	for(int i=0;i<n;i++){
		if(!isperfect(a[i]) || a[i]==1) cout<<"NO\n";
		else{
			ll s = sqrt(a[i]);
			if(prime[s]) cout<<"YES\n";
			else cout<<"NO\n";
		}
	}
	
	return 0;
}

