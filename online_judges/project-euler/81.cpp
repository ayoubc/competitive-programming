#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int a[1001][1001];
ll dp[1001][1001];
int n;
int main(){
	freopen("i.txt","r",stdin);
//	scanf("%d",&n);
	n = 80;
	for(int i=0;i<n;i++){
		for(int j=0;j<n;j++) scanf("%lld",&a[i][j]);
	}
	
	dp[0][0] = a[0][0];
	for(int i=1;i<n;i++) dp[0][i] = a[0][i] + dp[0][i-1];
	for(int i=1;i<n;i++) dp[i][0] = a[i][0] + dp[i-1][0];
	for(int i=1;i<n;i++){
		for(int j=1;j<n;j++){
			dp[i][j] = a[i][j] + min(dp[i-1][j],dp[i][j-1]);
		}
	}
	cout<<dp[n-1][n-1];
	return 0;
}

