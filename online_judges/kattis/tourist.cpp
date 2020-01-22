#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int N = 200005;
const int K = 21;
int ancestor[K][N];
int Level[N];
typedef vector<int> vi;
typedef vector<vi> graph;
graph g;

void dfs(int s,int p){
	ancestor[0][s] = p;
	for(int i=0;i<g[s].size();i++){
		if(g[s][i]!=p){
			Level[g[s][i]] = Level[s] + 1;
			dfs(g[s][i],s);
		}
	}
}
int getKthancestor(int s,int k){
	int d = Level[s] - k;
	for(int j=K-1;j>=0;j--){
		int curn = ancestor[j][s];
		if(curn==-1) continue;
		if(Level[curn]==d) return curn;
		else if(Level[curn]>d) s = curn;
	}
	return -1;
}
int getLCA(int a,int b){
	if(Level[a]>Level[b]) a = getKthancestor(a,Level[a] - Level[b]);
	else if(Level[b]>Level[a]) b = getKthancestor(b,Level[b] - Level[a]);

	if(a==b) return a;
	for(int j=K-1;j>=0;j--){
		int na = ancestor[j][a] , nb = ancestor[j][b];
		if(na!=-1 && nb!=-1 && na!=nb) {
			a = na;
			b = nb;
		}
	}
	return ancestor[0][a];
}
int main(){
	//freopen("i","r",stdin);
	int n,u,v;
	scanf("%d",&n);
	g.resize(n+1,vi());
	//vis.resize(n+1,false);
	for(int i=1;i<=n-1;i++){
		scanf("%d %d",&u,&v);
		//u--,v--;
		g[u].push_back(v);
		g[v].push_back(u);
	}
	memset(ancestor,-1,sizeof(ancestor));
	Level[1] = 0;
	dfs(1,-1);
	for(int j=1;j<K;j++){
		for(int i=1;i<=n;i++){
			ancestor[j][i] = (ancestor[j-1][i]==-1 ? -1 : ancestor[j-1][ancestor[j-1][i]]);
		}
	}
    ll ans = 0;
    for(int i=1;i<=n;i++){
        for(int j=2*i;j<=n;j+=i){
            int a = getLCA(i,j);
            ans += Level[i]+Level[j] - 2 * Level[a] + 1;
            //cout<<i<<" --> "<<j<<"="<<Level[i]+Level[j] - 2 * Level[a] + 1<<endl;;
        }
    }
    printf("%lld\n",ans);
	return 0;
}
