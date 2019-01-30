#include <bits/stdc++.h>

using namespace std;
typedef vector<int> vi;
typedef pair<int,int> pi;
int p,c;
vector<vi> initiate(vector<vi> g,int a,int b){
	vector<vi> newG(p,vi());
	for(int i=0;i<p;i++){
		for(int j=0;j<g[i].size();j++){
			if((i==a && g[i][j]==b) || (i==b && g[i][j]==a)) continue;
			newG[i].push_back(g[i][j]);
		}
	}
	return newG;
}

bool bfs(vector<vi> g ,int s){
	vector<int> vis(p,false);
	vis[s] = true;
	queue<int> Q;
	Q.push(s);
	while(!Q.empty()){
		int v = Q.front();
		Q.pop();
		for(int i=0;i<g[v].size();i++){
			if(vis[g[v][i]]) continue;
			vis[g[v][i]] = true;
			Q.push(g[v][i]);
		}
	}
	for(int i=0;i<p;i++){
		if(!vis[i])
			return false;
	}
	return true;
}
int main(){
	//freopen("i.in","r",stdin);
	int a,b;
	while(scanf("%d %d",&p,&c) && p && c){
		vector<vi> g(p,vi());
		vector<pi> edges;
		for(int i=1;i<=c;i++){
			scanf("%d %d",&a,&b);
			g[a].push_back(b);
			g[b].push_back(a);
			edges.push_back(make_pair(a,b));
		}
		bool ok = true;
		for(int i=0;i<c;i++){
			vector<vi> G = initiate(g,edges[i].first,edges[i].second);
			if(!bfs(G,0)){
				cout<<"Yes\n";
				ok = false;
				break;
			}
		}
		if(ok) cout<<"No\n";
	}
	return 0;
}

