//slowly but surly!
#include <bits/stdc++.h>
using namespace std;
typedef pair<int,int > pi;
typedef vector<int> vi;
int main(){
//	freopen("i","r",stdin);
	int n;
	scanf("%d",&n);
	int a,b;
	vector<vi> g(n+1,vi());
	set<pi> s2;
	vector<pi> v;
	for(int i=0;i<n-1;i++){
		scanf("%d %d",&a,&b);
		v.push_back(make_pair(a,b));
		g[a].push_back(b);
		g[b].push_back(a);
	}
	queue<pi> q;
	vector<bool> vis(n+1,false);
	q.push(make_pair(1,0));
	while(!q.empty()){
		pi p = q.front() ; q.pop();
		int node , level;
		node = p.first , level = p.second;
		if(level%2==0){
			for(int i=0;i<g[node].size();i++){
				if(!vis[g[node][i]]){
					vis[g[node][i]] = true;
					q.push(make_pair(g[node][i],level+1));
					s2.insert(make_pair(node,g[node][i]));
				}
			}
		}
		else{
			for(int i=0;i<g[node].size();i++){
				if(!vis[g[node][i]]){
					vis[g[node][i]] = true;
					q.push(make_pair(g[node][i],level+1));
					s2.insert(make_pair(g[node][i],node));
				}
			}
		}
	}
	for(int i=0;i<n-1;i++){
//		cout<<it->first<<" "<<it->second<<endl;
		if(s2.count(v[i])) printf("0\n");
		else printf("1\n");
	}
	
	return 0;
}

