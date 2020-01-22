//slowly but surly!
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef vector<int> vi;
typedef vector<vi> graph;
graph g;
vector<bool> vis;
const int N = 20005;
int n,m,nodes,samesize,cursize;
int id[N],size[N];
void dfs(int u){
	vis[u] = true;
	nodes++;
	samesize += (g[u].size()==cursize ? 1:0);
	for(int i=0;i<g[u].size();i++){
		if(!vis[g[u][i]]){
			dfs(g[u][i]);
		}
	}
}
/*void __init(int n){
	for(int i=0;i<n;i++){
		id[i] = i;
		size[i] = 1;
	}
}
int root(int a){
	while(a!=id[a]){
		id[a] = id[id[a]];
		a = id[a];
	}
	return a;
}
void Union(int a,int b){
	int p = root(a) , q = root(b);
	if(size[p]>size[q]){
		id[q] = p;
		size[p] += size[q];
	}
	else{
		id[p] = q;
		size[q] += size[p];
	}
}*/
int main(){
//	freopen("i","r",stdin);
	scanf("%d %d",&n,&m); 
	int u,v;
	g.clear();
	g.resize(n,vi());
	for(int i=0;i<m;i++){
		scanf("%d %d",&u,&v);
		u--,v--;
		g[u].push_back(v);
		g[v].push_back(u);
	}
	vis.clear();
	vis.resize(n,false);
	int ans = 0;
	for(int i=0;i<n;i++){
		if(!vis[i]){
			nodes = samesize = 0;
			cursize = g[i].size();
			if(cursize!=2) continue;
			dfs(i);
			ans += (nodes==samesize? 1:0);
		}
	}
	printf("%d\n",ans);
	return 0;
}

