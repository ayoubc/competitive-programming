#include<iostream>
#include <bits/stdc++.h>
#include <vector>
using namespace std;

int main(){
	long n,k,m;
	cin>>n>>k;
	bool prime[n+1];
	memset(prime,true,sizeof(prime));
	vector<long> d;
	for(int i=2;i*i<=n;i++){
		if(prime[i]){
			for(int j=2*i;j<=n;j+=i){
				prime[j] = false;
			}
		}
	}
	m = n;
	for(int i=2;i<=n;i++){
		if(prime[i] && m>1){
			while(m%i==0 && d.size() <k-1){
				m = m/i;
				d.push_back(i);
			}
		}
		if(d.size() == k-1 and m>1){
			d.push_back(m);
			break;
		}
	}
	if(d.size()==k){
		for(int j=0;j<k;j++){
			cout<<d[j]<<" ";
		}
		printf("\n");
	}
	else printf("-1\n");
	return 0;
}
