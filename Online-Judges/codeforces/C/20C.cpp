#include<bits/stdc++.h> 

using namespace std;
typedef long long ll; 
typedef pair<int,int> pi;
typedef pair<ll,int> pli;
typedef vector<pi> vpi;
const ll OO = 1000000000000;
int main(){
	// freopen("i","r",stdin);
	int n,m,a,b,w;
	scanf("%d %d",&n,&m);
	vector<vpi> g(n+1,vpi());
	vector<int> parent(n+1,1);
	vector<ll> dis(n+1,OO);
	vector<bool> vis(n+1,false);
	for(int i=0;i<m;i++){
		scanf("%d %d %d",&a,&b,&w);
		g[a].push_back(make_pair(b,w));
		g[b].push_back(make_pair(a,w));
	}
	dis[1] = 0;
	multiset<pli> mlt;
	mlt.insert(make_pair(0,1));
	while(!mlt.empty()){
		pi p = *mlt.begin();
		mlt.erase(mlt.begin());
		int b = p.second;
		if(vis[b]) continue;
		vis[b] = true;
		for(int i=0;i<g[b].size();i++){
			int e = g[b][i].first , w = g[b][i].second;
			if(dis[e] > dis[b] + w){
				dis[e] = dis[b] + w;
				parent[e] = b;
				mlt.insert(make_pair(dis[e],e));
			}
		}
	}
	if(dis[n]==OO) printf("-1\n");
	else{
		stack<int> st;
		int cur = n;
		while(cur!=parent[cur]){
			st.push(cur);
			cur = parent[cur];
		}
		printf("1 ");
		while(!st.empty()){
			printf("%d ",st.top());
			st.pop();
		}
	}
}