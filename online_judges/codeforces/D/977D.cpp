//slowly but surly!
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef vector<int> vi;
typedef vector<vi> graph;
graph g;
const int N = 105;
ll a[N];
int n;

vector<ll> V;
int parent[N];
void bfs(int s,vector<bool> &vis){
	memset(parent,-1,sizeof(parent));
	queue<int> q;
	q.push(s);
	vis[s] = true;
	while(!q.empty()){
		int v = q.front();
		q.pop();
	
		for(int i=0;i<g[v].size();i++){
			int index = g[v][i];
			if(!vis[index]){
				vis[index] = true;
				parent[index] = v;
				q.push(index);
			}
		}
	}
	
}

int main(){
//	freopen("i","r",stdin);
	int n;
	scanf("%d",&n); 
	for(int i=0;i<n;i++) scanf("%lld",&a[i]);
	g.clear();
	g.resize(n,vi());
	for(int i=0;i<n;i++){
		for(int j=0;j<n;j++){
			if(i==j) continue;
			if(2*a[i]==a[j]){
				g[i].push_back(j);
			}
			else if(3*a[i]==a[j]){
				g[j].push_back(i);
			}
		}
	}
	int to;
	for(int i=0;i<n;i++){
		if(g[i].size()==0){
			to = i;
			break;
		}
	}
//	cout<<to<<endl;
	for(int i=0;i<n;i++){
		vector<bool> vis(n,false);
		bfs(i,vis);
		bool ok = true;
		for(int j=0;j<n;j++){
			if(!vis[j]){
				ok = false;
				break;
			}
		}
		
		//for(int j=0;j<n;j++) printf("%d ",parent[j]);
		//cout<<"\n";
		if(ok){
			parent[i] = i;
			int cur = to;
			stack<int> st;
			printf("%lld ",a[i]);
			while(parent[cur]!=cur){
				st.push(cur);
				cur = parent[cur];
			}
			while(!st.empty()){
				printf("%lld ",a[st.top()]);
				st.pop();
			}
			printf("\n");
			break;
			//for(int j=0;j<n;j++) printf("%d ",parent[j]);
		}
	}
	/*for(int i=0;i<n;i++){
		printf("%d : ",a[i]);
		for(int j=0;j<g[i].size();j++) printf("%d ",a[g[i][j]]);
		printf("\n");
	}*/
	/*vis.resize(n,false);
	bfs(n-1);
	for(int i=0;i<n;i++) printf("%d ",parent[i]);*/
	return 0;
}

