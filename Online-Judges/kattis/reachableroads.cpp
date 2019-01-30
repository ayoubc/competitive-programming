#include <bits/stdc++.h>
using namespace std;
const int M = 1005;
bool vis[M];
typedef vector<int> vi;

void dfs(int s,vector<vi> g){
	if(vis[s]){
		return ;
	}
	vis[s] = true;
	for(int i=0;i<g[s].size();i++){
		if(!vis[g[s][i]]){
			dfs(g[s][i],g);
		}
	}
}
int main(){
//	freopen("i","r",stdin);
	int n,m,r,ans,u,v;
	scanf("%d",&n);
	while(n--){
		scanf("%d",&m);
		scanf("%d",&r);
		ans = 0;
		memset(vis,false,sizeof(vis));
		vector<vi> g(m,vi());
		for(int i=0;i<r;i++){
			scanf("%d%d",&u,&v);
			g[u].push_back(v);
			g[v].push_back(u);
		}
		for(int i=0;i<m;i++){
			if(!vis[i]){
				ans++;
				dfs(i,g);
			}
		}
		printf("%d\n",ans-1);
	}
	return 0;
}

