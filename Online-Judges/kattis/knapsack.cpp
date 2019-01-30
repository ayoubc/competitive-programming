#include<bits/stdc++.h>

using namespace std;
int dp[2005][2005];
int V[2005],W[2005];
int main(){
	freopen("i","r",stdin);
	int n,w,c,v;
	double C;
	while(cin >> C >> n){
		c = (int)C;
		for(int i=0;i<n;i++) scanf("%d %d",&V[i],&W[i]);
		for(int i=1;i<=n;i++){
			w = W[i-1] , v = V[i-1];
			for(int sz=1;sz<=c;sz++){
				dp[i][sz] = dp[i-1][sz];
				if(sz >= w && dp[i-1][sz-w]+v>dp[i][sz]){
					dp[i][sz] = dp[i-1][sz-w] + v;
				}
			}
		}
		int sz = c;
		vector<int> items;
		for(int i=n;i>0;i--){
			if(dp[i][sz]!=dp[i-1][sz]){
				int selected = i-1;
				items.push_back(selected);
				sz -= W[selected];
			}
		}
		printf("%d\n",(int)items.size());
		for(int i=0;i<items.size();i++)
			printf("%d ",items[i]);
		printf("\n");
	}
}