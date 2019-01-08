#include<bits/stdc++.h>

using namespace std;
typedef long long ll;
int main(){
	// freopen("i","r",stdin);
	ll n,m,ans;
	cin >> n;
	cin >> m;
	if(n>27)
		ans = m;
	else{
		ans = m%(1LL<<n);
	}
	cout<<ans<<endl;
	return 0;
}