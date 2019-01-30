#include <bits/stdc++.h>

using namespace std;
typedef unsigned long long ull;
const int nmax = 100000;



vector<ull> seive(){
	vector<ull> primes;
	primes.push_back(2);
	for(int i=3;i<=nmax;i+=2){
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
ull euler(ull n,vector<ull> primes){
	ull ans = n,P = 1;
	 
	for(ull i=0;i<=primes.size();i++){
		if(n%primes[i]==0 && primes[i]!=0){
			ans *= (primes[i] - 1);
			ans /= primes[i];
		}
	}
	
	return ans;
}
int main(){
	ios_base::sync_with_stdio(false);
	//ifstream cin("r.in");
	ull n;
	vector<ull> primes = seive();
	while(cin>>n && n){
		cout<<euler(n,primes)<<endl;
	}
	
	return 0;
}

