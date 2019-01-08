
#include <bits/stdc++.h>

#define mp make_pair
using namespace std;
typedef pair<int,int> pi;

typedef long long ll;
const int mod = (int)1e09 +7;
long  long Min(long long a,long long b){
	return (a<=b) ? a:b;
}



ll power(ll a,ll x,ll mod){
	if(x==0) return 1;
	ll d = power(a,x/2,mod);
	if(x%2==0){
		return ((d%mod)*(d%mod))%mod;
	}
	else{
		return ((((d%mod)*(d%mod))%mod)*(a%mod))%mod;
	}

}
bool sameparity(ll n,ll m){
	return (n%2==0 && m%2==0) || (n%2==1 && m%2==1);
}
int main() {
	// freopen("i.in","r",stdin);
    ll n,m;
    int k;
    scanf("%I64d %I64d %d",&n,&m,&k);

    if(k==-1 && !sameparity(n,m)) printf("0\n");
    else printf("%I64d",power(power(2,n-1,mod),m-1,mod));
    return 0;
}