#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
ll maxl(ll a, ll b) {
    return a>b ? a : b;
}
ll largestPrime(ll n) {
    ll ans = 2;
    for(ll i=2;i*i<=n;i++){
        if(n%i==0) ans = maxl(ans, i);
        while(n%i==0) n /= i;
    }

    if (n>1) ans = maxl(ans, n);
    //cout << ans << endl;
    return ans;
}



int main(){
    int t;
    scanf("%d", &t);

    while(t--) {
        ll n;
        scanf("%lld", &n);
        printf("%lld\n", largestPrime(n));
        //printf("%lld\n", n);
    }

	return 0;
}
