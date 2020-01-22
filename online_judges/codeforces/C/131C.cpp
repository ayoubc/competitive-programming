#include<bits/stdc++.h>

using namespace std;
typedef long long ll;

ll nCk[101][101];
void compute(){
	for(int i=0;i<=100;i++){
		nCk[i][i] = 1;
		nCk[i][0] = 1;
	}
	for(int i=1;i<=100;i++){
		for(int j=1;j<=i;j++){
			nCk[i][j] = nCk[i-1][j] + nCk[i-1][j-1];
		}
	}
}

int main(){
	// freopen("i","r",stdin);
	compute();
	int n,m,t;
	scanf("%d%d%d",&n,&m,&t);
	ll ans = 1;
	// for(int b=4;b<=t-1;b++){
	// 	ans += nCk[n][b]*nCk[m][t-b];
	// }
	// for(int i=1;i<=18;i++){
	// 	ans *= i;
	// }
	printf("%I64d\n",ans);
}