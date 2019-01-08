#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
const ll limit = 1000000000000000000;
set<ll> all;
vector<ll> gen;
const double EPS = 1e-8;
ll power(ll x,int n){
    if(n==0) return 1;
    if(n==1) return x;
    ll d = power(x,n/2);
    d = d*d;
    if(n%2!=0) d = d*x;
    return d;
}
ll root(ll x) {
	ll l = 0, r = 1e9 + 1;
	while (l < r - 1) {
		ll m = (l + r) / 2;
		if (m * m > x) r = m;
		else l = m;
	}
	return l;
}
int main(){
    //freopen("i.txt","r",stdin);
    //freopen("out.txt","w",stdout);
    int q;
    ll L,R;
    scanf("%d",&q);
    for(int p=3;p<=63;p+=2){
        for(ll x=1;;x++){
            ll cur = power(x,p);
            if(cur>limit) break;
            if(cur>0) all.insert(cur);
        }
    }

    for(set<ll>::iterator it=all.begin();it!=all.end();it++){
        ll x = *it , cur = root(x);
        if(cur*cur != x) gen.push_back(x);
    }
    while(q--){
        scanf("%I64d%I64d",&L,&R);
        ll ans = upper_bound(gen.begin(),gen.end(),R) - lower_bound(gen.begin(),gen.end(),L);
        ans += root(R) - (L==1 ? 0 : root(L-1));
        printf("%I64d\n",ans);
    }
    return 0;
}
