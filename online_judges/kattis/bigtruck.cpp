#include <bits/stdc++.h>

using namespace std;
typedef pair<int,int> pi;

const int OO = (int)1e09;
typedef vector<pi> vpi;


struct place{
	int items,distance,node;
	place(int _items,int _distance,int _node){
		items = _items , distance = _distance, node = _node;
	}
	bool operator < (place p) const {
		if(items == p.items){
			return distance >= p.distance;
		}
		return items < p.items;
		
	}
};

int main(){
//	freopen("input","r",stdin);
	int n,m,a,b,d,item;
	scanf("%d",&n);
	int t[n+1];
	for(int i=1;i<=n;i++)
		scanf("%d",&t[i]);
	
	
	vector<vpi> g(n+1,vpi());
	scanf("%d",&m);
	for(int i=1;i<=m;i++){
		scanf("%d %d %d",&a,&b,&d);
		g[a].push_back(make_pair(b,d));
		g[b].push_back(make_pair(a,d));
	}
	vector<int> dis(n+1,OO);
	vector<int> items(n+1,0);
	

	priority_queue<place> q;
	dis[1] = 0;
	items[1] = t[1];

	q.push(place(items[1],0,1));
	while(!q.empty()){

		place p = q.top(); q.pop();

		item = p.items , a = p.distance , b = p.node;
		
		for(int j=0;j<g[b].size();j++){
			int e = g[b][j].first , w = g[b][j].second;
			if(dis[b] + w < dis[e] || (dis[b] + w == dis[e] && items[b] + t[e] > items[e])){
				dis[e] = dis[b] + w;
				items[e] = items[b] + t[e];
				q.push(place(items[e],dis[e],e));

			}
		}
	}
	if(dis[n] == OO) printf("impossible\n");
	else printf("%d %d",dis[n], items[n]);
	
	return 0;
}

