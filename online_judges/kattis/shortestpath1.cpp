#include <bits/stdc++.h>
#include <vector>

using namespace std;
const int INF = 1e09;
typedef pair<int,int> pii;
typedef vector<pii> vpi;
int main(){
	//freopen("i.in","r",stdin);
	int n,m,q,s,u,v,w;
	//scanf("%d %d %d %d",&n,&m,&q,&s)==2
//	cin>>n>>m>>q>>s
	while(scanf("%d %d %d %d",&n,&m,&q,&s)){
		if(n==0) return 0;
		vector<vpi> g(n,vpi());
		for(int i=1;i<=m;i++){
			scanf("%d %d %d",&u,&v,&w);
			g[u].push_back(make_pair(v,w));
			//g[v].push_back(make_pair(u,w));
		}
		
		
		vector<int> dist(n,INF);
		dist[s] = 0;
		multiset<pii> mlt;
		mlt.insert(make_pair(0,s));
		while(!mlt.empty()){
			pii p = *mlt.begin();
			mlt.erase(mlt.begin());
			int a = p.first, b = p.second;
			//cout<<a<<" "<<b<<endl;
			for(int i=0;i<g[b].size();i++){
				int u = g[b][i].first,w = g[b][i].second;
				if(dist[u] > a + w){
					dist[u] = a + w;
					mlt.insert(make_pair(dist[u],u));
				}
			}
		}
		while(q--){
			scanf("%d",&u);
			if(dist[u]==INF) printf("Impossible\n");
			else printf("%d\n",dist[u]);
		}
		printf("\n");
	}
	return 0;
}

