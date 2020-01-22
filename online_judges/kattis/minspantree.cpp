#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
#include <algorithm>
using namespace std;

struct edge{
	int u,v,w;
	edge (int _u, int _v, int _w) { u = _u, v = _v, w = _w;}
	bool operator < (edge e) const { return w > e.w; }
};
typedef vector<edge> ve; 
int main(){
//	freopen("input","r",stdin);
	int n,m,u,v,w;
	while (scanf("%d%d",&n,&m)==2){
		if(n==0 && m==0)
			break;
		vector<ve> g(n,ve()); // graph
		for (int i=0;i<m;i++){
			scanf("%d%d%d",&u,&v,&w);
			g[u].push_back(edge(u,v,w));
			g[v].push_back(edge(v,u,w));
		}
		// Prim (MST)
		priority_queue<edge> q;
		ve mst;
		vector<bool> vis(n,false);
		long long sum = 0;
		vis[0] = true;
		for (int i=0;i<g[0].size();i++) q.push(g[0][i]);
		while (mst.size() < n-1 && !q.empty()){

			edge e = q.top(); q.pop();
			u = e.u;
			v = e.v;
			w = e.w;

			if (vis[u] && vis[v]) continue;
			if (vis[u]){
				for (int i=0;i<g[v].size();i++) q.push(g[v][i]);
			}
			if (vis[v]){
				for (int i=0;i<g[u].size();i++) q.push(g[u][i]);
			}

			vis[u] = vis[v] = true;
			mst.push_back(e);
			sum += w;
		}
		if (mst.size() == n-1){
				printf("%lld\n",sum);
				pair<int,int> a[n-1];
				for (int i=0;i<n-1;i++) a[i].first = min(mst[i].u,mst[i].v), a[i].second = max(mst[i].u,mst[i].v);
				sort(a,a+(n-1));
				for (int i=0;i<n-1;i++) cout << a[i].first << " " << a[i].second << endl;

		}
		else
			printf("Impossible\n");
	}
	return 0;
}
