#include <bits/stdc++.h>
using namespace std;
typedef vector<int> vi;
vector<vi> g;
int n;
int bfs(int s){
	vector<bool> vis(n+1,false);
	vector<int> dis(n+1,0);
	queue<int> q;
	q.push(s);
	vis[s] = true;
	while(!q.empty()){
		int u = q.front();
		q.pop();
		for(int i=0;i<g[u].size();i++){
			int v = g[u][i];
			if(!vis[v]){
				vis[v] = true;
				dis[v] = dis[u]+1;
				q.push(v);
			}
		}
	}
	return *max_element(dis.begin(),dis.end());
}
int main(){
	//freopen("i.txt","r",stdin);
	scanf("%d",&n);
	vector<int> p(n+1);
	g.resize(n+1,vi());
	for(int i=1;i<=n;i++){
		scanf("%d",&p[i]);
		if(p[i]!=-1){
			g[p[i]].push_back(i);
		}
	}
	int ans = 0;
	for(int i=1;i<=n;i++){
		if(p[i]==-1){
			ans = max(ans,bfs(i)+1);
		}
	}
	printf("%d\n",ans);
	return 0;
}

