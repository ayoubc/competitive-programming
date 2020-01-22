#include <bits/stdc++.h>

using namespace std;
typedef vector<int> vi;
int main(){
	//freopen("i.in","r",stdin);
	int c,p,x,l,a,b;
	scanf("%d %d %d %d",&c,&p,&x,&l);
	vector<vi> g(c+1,vi());
	vi pa(c+1,0);
	vi panow(c+1,0);
	for(int i=0;i<p;i++){
		scanf("%d %d",&a,&b);
		g[a].push_back(b);
		g[b].push_back(a);
		pa[a]++;
		panow[a]++;
		pa[b]++;
		panow[b]++;
	}
	
	if(x==l){
		printf("leave\n");
		return 0;
	}
	bool leave = false;
	vector<bool> vis(c+1,false);

	queue<int> Q;
	vis[l] = true;
	Q.push(l);
	while(!Q.empty()){
		int v = Q.front();
		Q.pop();
		for(int i=0;i<g[v].size();i++){
			int u = g[v][i],s;
			if(!vis[u]){
				
				panow[u]--;
				if(panow[u] <= pa[u]/2){
					if(u==x){

						printf("leave\n");
						return 0;
					}
					else{
						Q.push(u);
						vis[u] = true;
					}
				}
			}
			
		}
	}
	printf("stay\n");
	return 0;
}

