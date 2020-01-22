#include <bits/stdc++.h>

using namespace std;
const double EPS = 1e-5;
typedef pair<int,double> pid;
typedef pair<double,int> pdi;
typedef vector<pid> vpid;
int main(){
	
//	freopen("input","r",stdin);
	int n,m,u,v;
	double f,ftmp;
	while(scanf("%d %d",&n,&m)==2){
		if(n==0 && m==0)
			break;
		
		
		vector<vpid> g(n,vpid());
		for(int i=0;i<m;i++){
			cin >> u >> v >> f;
//			scanf("%d %d %f",&u,&v,&f); here a problem of readin the input you should know why to avoid such problems
			g[u].push_back(make_pair(v,f));
			g[v].push_back(make_pair(u,f));
		}
		vector<bool>vis(n,false);
		vector<double> fric(n,0.0);
		priority_queue<pdi> pq;
		fric[0] = 1.0;
		pq.push(make_pair(1.0,0));
		while(!pq.empty()){
			pdi p = pq.top(); pq.pop();
			f = p.first , u = p.second;
//			printf("%d hello \n",u);
//			printf("%.4f  \n",fric[u]);
			if(vis[u])
				continue;
			vis[u] = true;
			for(int i=0;i<g[u].size();i++){
				v = g[u][i].first;
				ftmp = g[u][i].second;
//				printf("%.4f just a fric \n",ftmp);
				if(fric[v] < f*ftmp){
					fric[v] = f*ftmp;
//					printf("%.4f hello \n",fric[v]);
					pq.push(make_pair(fric[v],v));
				}
			}
		}
		printf("%.4f\n",fric[n-1]);
	}
	
	return 0;
}

