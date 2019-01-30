#include<bits/stdc++.h>
#include<time.h>
using namespace std; 
typedef long long ll;
ll power(ll a,ll n){
	if(n==1) return a;
	ll d = power(a,n/2);
	if(n%2==0) return d*d;
	else return d*d*a;
}
// int gcd(int a,int b){
// 	return (b==0?a:gcd(b,a%b));
// }
// int pollardRho(int n){
	
// 	if(n%2==0) return 2;
// 	int x = (rand()%999999) + 2;
// 	int c = (rand()%999999) + 2;
// 	int y = x , d = 1;
// 	while(d==1){
// 		x = (x*x + c)%n;
// 		y = (y*y + c)%n;
// 		y = (y*y + c)%n;
// 		d = gcd(abs(x-y),n);
// 		if(d==n)break;
// 	}
// 	return d;
// }
// bool isprime(int n){
// 	if(n<2) return false;
// 	if(n==2 || n==3) return true;
// 	if(n%2==0 || n%3==0) return false;
// 	int limit = sqrt(n);
// 	for(int i=5;i<=limit ;i+=6){
// 		if(n%i==0 || n%(i+2)==0) 
// 			return false;
// 	}
// 	return true;
// }
// map<int,int> primeFactorisation(int n){
// 	map<int,int> A;
// 	if(n==1) return A;
// 	priority_queue<int> pq;
// 	pq.push(n);
// 	while(!pq.empty()){
// 		int divisor = pq.top(); pq.pop();
// 		if(isprime(divisor)){
// 			A[divisor]++;
// 			continue;
// 		}
// 		int next = pollardRho(divisor);
// 		if(next==divisor) pq.push(divisor);
// 		else{
// 			pq.push(next);
// 			pq.push(divisor/next);
// 		}
// 	}
// 	return A;
// }
map<int,int> primeFactorisation(int n){
	map<int,int> A;
	int j = sqrt(n);
	for(int i=2;i<=j;i++){
		while(n%i==0){
			A[i]++;
			n /= i;
		}
		j = sqrt(n);
	}
	if(n>1) A[n]++;
	return A;
}
int powerOfprimeInFactoriel(int p,int n){
	int ans = 0,divisors;
	for(int x=1;;x++){
		divisors = n/power(p,x);
		if(divisors==0) break;
		ans += divisors;
	}
	return ans;
}
int main(){
	// freopen("i","r",stdin);
	// srand(time(NULL));
	int n,m;
	while(scanf("%d %d",&n,&m)==2){
		if(m==0) printf("%d does not divide %d!\n",m,n);
		else if(m<=n) printf("%d divides %d!\n",m,n);
		else{
			bool ok = true;	
			map<int,int> A = primeFactorisation(m);
			for(map<int,int>::iterator it=A.begin();it!=A.end();it++){
				int Prime = it->first;
				if(powerOfprimeInFactoriel(Prime,n)<A[Prime]){
					ok = false;
					break;
				}
			}
			if(ok) printf("%d divides %d!\n",m,n);
			else printf("%d does not divide %d!\n",m,n);
		}
		
	}
}