#include <bits/stdc++.h>
using namespace std;
map<int,int> fac(int n){
	map<int,int > a;
	for(int i=2;i<=n/i;i++){
		if(n%i==0){
			while(n%i==0){
				a[i]++;
				n/=i;
				
			}
		}
	}
	if(n> 1){
		a[n]++;
	}
	return a;
}
long long power(int x,int n){
	if(n==1){
		return x;
	}
	long long d = power(x,n/2);
	if(n%2==0)
		return d*d;
	else 
		return d*d*x;
}
int main(){
//	freopen("i","r",stdin);
	int n;
	while(scanf("%d",&n)==1){
		map<int,int> A = fac(n);
		long long ans = 1;
		for(map<int,int>::iterator it=A.begin();it!=A.end();it++){
			int e = it->second , p = it->first;
			ans *= power(e,p);
		}
		printf("%d %lld\n",n,ans);
	}
	return 0;
}

