#include <bits/stdc++.h>
#include <vector>
#include <iostream>
using namespace std;
typedef vector<int> vi;
int main(){
	ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    
    //ifstream cin("i.txt");
	int n,u,v;
	cin>>n;
	vector<vi> g(n+1,vi());
	vector<bool> vis(n+1,false);
	vi dis(n+1,0);
	vector<double> prob(n+1,1);
	for(int i=1;i<=n-1;i++){
		cin>>u>>v;
		g[u].push_back(v);
		g[v].push_back(u);
	}
	vis[1] = true;
	dis[1] = 0;
	queue<int> Q;
	Q.push(1);
	while(!Q.empty()){
		int e = Q.front();
		Q.pop();
		for(int i=0;i<g[e].size();i++){
			if(!vis[g[e][i]]){
				dis[g[e][i]] = dis[e] + 1;
				vis[g[e][i]] = true;
				if(e==1) prob[g[e][i]] = prob[e]*1.0/(g[e].size());
				else prob[g[e][i]] = prob[e]*1.0/(g[e].size()-1);
				
				Q.push(g[e][i]);
			}
		}
	}
	double ans = 0;
	for(int i=1;i<=n;i++){
		if(g[i].size()==1){
			ans += prob[i]*dis[i];
			//cout<<prob[i]<<endl;
		}
	}
	//for(int i=1;i<=n;i++) cout<<prob[i]<<" ";
	printf("%.15f\n",ans);
	return 0;
}

