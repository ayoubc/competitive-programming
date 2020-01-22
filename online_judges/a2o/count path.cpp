#include<iostream>
#include <bits/stdc++.h>
using namespace std;
const long long mod = 1000000007;



int main(){
	int n,m;
	//ifstream cin("I");
	while(cin>>n>>m && (n!=-1 && m!=-1)){
		long long v[n+1][m+1];
		for(int i=0;i<=n;i++){
			for(int j=0;j<=m;j++){
				if(i==0 && j==0){
					v[i][j] = 0;
				}
				else if(i==0 || j==0){
					v[i][j] = 1;
				}
				else{
					v[i][j] = (v[i-1][j]%mod+v[i][j-1]%mod)%mod;
				}
			}
		}
		cout<<v[n][m]%mod<<endl;
	}
	return 0;
}

