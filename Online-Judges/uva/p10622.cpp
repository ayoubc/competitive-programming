#include <bits/stdc++.h>

using namespace std;
typedef  long long ll;
const int N = 100000;
vector<ll> seive(){
	vector<ll> primes;
	primes.push_back(2);
	for(ll i=3;i<=N;i+=2){
		bool ok = true;
		for(int j=0;j<primes.size(),primes[j]*primes[j]<=i;j++){
			if(i%primes[j]==0){
				ok = false;
				break;
			}
		}
		if(ok) primes.push_back(i);
	}
	return primes;
}
ll gcd(ll a,ll b){
	if(b==0){
		return a;
	}
	return gcd(b,a%b);
}
ll multiple_gcd(vector<ll> v){
	ll ans = v[0];
	for(int i=1;i<v.size();i++){
		ans = gcd(ans,v[i]);
	}
	return ans;
}
int main(){
	ios_base::sync_with_stdio(false);
	//freopen("i.in","r",stdin);
	//freopen("out.o","w",stdout);
	ll n;
	vector<ll> primes = seive();
	
	while(scanf("%lld",&n)==1 && n){
		bool neg = false;
		if(n<0){
			neg = true;
			n *= -1;
		}
		vector<ll> power;
		ll tmp = n,cnt;
		for(int j=0;j<primes.size(),primes[j]*primes[j]<=n;j++){
			cnt = 0;
			while(tmp%primes[j]==0){
				cnt++;
				tmp /= primes[j];
			}
			power.push_back(cnt);
		}
		if(tmp!=1) power.push_back(1);
		int out = multiple_gcd(power);
		if(neg){
			while(out%2==0 && out>1){
				out /= 2;
			}
			printf("%d\n",out);
		} 
		else printf("%d\n",out);
	}
	
	return 0;
}

