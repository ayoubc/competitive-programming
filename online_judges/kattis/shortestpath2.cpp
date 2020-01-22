#include<bits/stdc++.h>

using namespace std;

typedef long long ll;
const int OO = 1000000000;
struct edge{
	int to,P,t0,d;
	edge(int _v,int _t0,int _P,int _d){
		this->to = _v;
		this->t0 = _t0;
		this->P = _P;
		this->d = _d;
	}
};
typedef vector<edge> ve;
typedef pair<int,int> pi;
int f(int t0,int P,int dist){
	if(P==0){
		if(dist>t0) return OO;
		else t0 - dist;
	}
	if(t0>=dist) return t0 - dist;
	int t = (dist - t0 + P - 1)/P;
	return t0 + t*P - dist;
}
int main(){
	// freopen("i","r",stdin);
	int n,m,u,v,P,t0,d,s,q,tmp;
	while(scanf("%d%d%d%d",&n,&m,&q,&s)==4){
		if(n==0 && m==0 && q==0 && s==0)
			break;

		vector<ve> g(n,ve());
		for(int i=0;i<m;i++){
			scanf("%d %d %d %d %d",&u,&v,&t0,&P,&d);
			g[u].push_back(edge(v,t0,P,d));
		}
		vector<bool> vis(n,false);
		vector<int> time(n,OO);
		multiset<pi> mlt;
		time[s] = 0;
		mlt.insert(make_pair(0,s));
		while(!mlt.empty()){
			pi p = *(mlt.begin());
			mlt.erase(mlt.begin());
			int b = p.second;
			if(vis[b]) continue;
			vis[b] = true;
			for(int i=0;i<g[b].size();i++){
				edge E = g[b][i];
				int w = f(E.t0,E.P,time[b]) + E.d;
				if(time[b] + w < time[E.to]){
					time[E.to] = time[b] + w;
					mlt.insert(make_pair(time[E.to],E.to));
				}
			}
		}
		for(int i=0;i<q;++i){
			scanf("%d",&u);
			if(time[u]==OO) printf("Impossible\n");
			else printf("%d\n",time[u]);
		}
		printf("\n");
	}
	return 0;
}