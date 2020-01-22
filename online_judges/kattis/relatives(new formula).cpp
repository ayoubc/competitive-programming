#include <bits/stdc++.h>

using namespace std;
const int nmax = 100000;
typedef unsigned long long ull;
ull gcd(ull a,ull b){
	if(b==0){
		return a;
	}
	return gcd(b,a%b);
}
vector<ull> primes;
void seive(){
	//vector<ull> primes;
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
	//return primes;
}

bool isprime(ull p){
	for(int i=0;i<primes.size(),primes[i]*primes[i]<=p;i++){
		if(p%primes[i]==0){
			//cout<<primes[i]<<endl;
			return false;
		}
	}
	return true;
}

ull phi(ull n){
	if(n==2 || n==1){
		return 1;
	}
	else if(isprime(n)){
		return n-1;
	}
	else if(n%2==0){
		ull k = n/2;
		if(k%2==0){
			
			return 2*phi(k);
		}
		else{
			return phi(k);
		}
	}
	else{
		ull a,b;
		for(ull i = 3;i*i<n;i+=2){
			if(n%i==0 && gcd(i,n/i)==1){
				a = i;
				b = n/i;
				return phi(a)*phi(b);
			}
		}	
	}
	
}
int main(){
	ios_base::sync_with_stdio(false);
	seive();
	//for(int i=0;i<primes.size();i++) cout<<primes[i]<<endl;
	ifstream cin("r.in");
	ull n;
	while(cin>>n && n){
		cout<<phi(n)<<endl;
	}
	return 0;
}

