//slowly but surly!
#include <bits/stdc++.h>
using namespace std;
typedef vector<int> vi;
const int N = 100001;
const int l = 16;
vector<vi> g;
int n,dpth[N],dp[l+1][N];
void dfs(int u,int p){
	dp[0][u] = p;
	
	for(int i=0;i<g[u].size();i++){
		if(g[u][i] != p){
			dpth[g[u][i]] = dpth[u] + 1;
			dfs(g[u][i], u);
		}
	}
}
int getKthAncestor(int u,int k){
	int d = dpth[u] - k;
	for(int j=l;j>=0;j--){
		int nu = dp[j][u];
		if(nu==-1) continue;
		if(dpth[nu] == d) return nu;
		else if(dpth[nu]>d) u = nu;
	}
	return -1;
}
int getLCA(int a,int b){
	if(dpth[a]>dpth[b]) a = getKthAncestor(a,dpth[a] - dpth[b]);
	else if(dpth[a]<dpth[b]) b = getKthAncestor(b,dpth[b] - dpth[a]);
	
	if(a==b) return a;
	
	for(int j=l;j>=0;j--){
		int na = dp[j][a] , nb = dp[j][b];
		if(na!=-1 && nb!=-1 && na!=nb){
			a = na;
			b = nb;
		}
	}
	return dp[0][a];
}
int main(){
	//freopen("i","r",stdin);
	int t;
	scanf("%d",&t);
	for(int tc=1;tc<=t;tc++){
		scanf("%d",&n);
		g.clear();
		g.resize(n,vi());
		int m,u;
		
		for(int i=0;i<n;i++){
			scanf("%d",&m);
			for(int k=1;k<=m;k++){
				scanf("%d",&u);
				u--;
				g[i].push_back(u);
				g[u].push_back(i);
			}
		}
		memset(dp,-1,sizeof(dp));
		dpth[0] = 0;
		dfs(0,-1);
		for(int j=1;j<=l;j++){
			for(int i=0;i<n;i++){
				dp[j][i] = (dp[j-1][i]==-1 ? -1 : dp[j-1][dp[j-1][i]]);
			}
		}
		int q,a,b;
		printf("Case %d:\n",tc);
		scanf("%d",&q);
		while(q--){
			scanf("%d %d",&a,&b);
			a--,b--;
			printf("%d\n",getLCA(a,b)+1);
		}
	}
	return 0;
}

