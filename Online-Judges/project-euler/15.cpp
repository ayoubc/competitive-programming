#include<iostream>
#include <bits/stdc++.h>
using namespace std;
int main(){
	long long  dp[100][100];
	dp[0][0] = 0;
	int n=21,m=21;
	for(int i=0;i<n;i++){
		for(int j=0;j<m;j++){
			if(i==0&&j==0){
				dp[i][j] = 0;
			}
			else if(i==0||j==0){
				dp[i][j] = 1;
			}
			else{
				dp[i][j] = dp[i][j-1]+dp[i-1][j];
			}
		}
	}
	cout<<dp[n-1][m-1]<<endl;
	return 0;
}
