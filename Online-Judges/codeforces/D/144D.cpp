#include<bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair<int,int> pi;
typedef pair<pi,int> pii;
typedef vector<pi> vpi;
const ll OO = 1000000000;
vector<vpi> g;
vector<bool> vis;
vector<int> dis;
vector<pii> V;
int n,m,s,l,u,v,w,ans;

int main(){
	// freopen("i","r",stdin);
	
	scanf("%d%d%d",&n,&m,&s);
	g.clear(),g.resize(n+1,vpi());
	// vector<vpi> g(n+1,vpi());
	for(int i=0;i<m;i++){
		scanf("%d%d%d",&v,&u,&w);
		g[u].push_back(make_pair(v,w));
		g[v].push_back(make_pair(u,w));
		V.push_back(make_pair(make_pair(u,v),w));
	}
	scanf("%d",&l);
	dis.clear(), dis.resize(n+1,OO);
	vis.clear(), vis.resize(n+1,false);
	dis[s] = 0;
	multiset<pi> mlt;
	mlt.insert(make_pair(0,s));
	while(!mlt.empty()){
		pi p = *(mlt.begin());
		mlt.erase(mlt.begin());
		int b = p.second;
		if(vis[b]) continue;
		vis[b] = true;
		for(int i=0;i<g[b].size();i++){
			int e = g[b][i].first , w = g[b][i].second;
			if(dis[e]>dis[b]+w){
				dis[e] = dis[b] + w;
				mlt.insert(make_pair(dis[e],e));
			}
		}
	}
	ans = 0;
	for(int j=0;j<m;j++){
		pii p = V[j];
		int a,b,to,w;
		a = p.first.first , b = p.first.second , w = p.second;
		// cout<<a<<" "<<b<<" "<<w<<endl;
 		if(dis[a]<l && l - dis[a]<w && w - (l-dis[a]) + dis[b]>l) ans++;
		if(dis[b]<l && l - dis[b]<w && w - (l-dis[b]) + dis[a]>l) ans++;
		if(dis[a]<l && dis[b]<l && dis[a]+dis[b]+w==2*l) ans++;
	}
	for(int i=1;i<=n;i++){
		if(dis[i]==l) ans++;
	}
	printf("%d\n",ans);
}