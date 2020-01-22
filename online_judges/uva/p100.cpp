#include<iostream>
#include <bits/stdc++.h>
using namespace std;
long f(int n){
	long cnt =1;
	while(n!=1){
		cnt++;
		if(n%2==0) n/=2;
		else n = 3*n+1;
	}
	return cnt;
}
int main(){
	int i,j,I,J;
	while(cin>>i>>j){
		long ans = INT_MIN;
		I = min(i,j);
		J = max(i,j);
		for(int k=I;k<=J;k++){
			ans = max(ans,f(k));
		}
		cout<<i<<" "<<j<<" "<<ans<<endl;
	}
	return 0;
}

