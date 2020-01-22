//slowly but surly!
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef pair<int,ll> pli;
typedef vector<pli> vpli;
typedef vector<vpli> graph;
graph g;
const int l = 16;
const int N = 10001;
ll dist[N];
int dp[l+1][N] ,depth[N];
void dfs(int u,int p){
	dp[0][u] = p;
	
	for(int i=0;i<g[u].size();i++){
		int v = g[u][i].first , w = g[u][i].second;
		if(v!=p){
			dist[v] = dist[u] + w;
			depth[v] = depth[u] + 1;
			dfs(v,u);
		}
	}
}
void jump(int n){
	for(int j=1;j<=l;j++){
		for(int i=0;i<n;i++){
			dp[j][i] = (dp[j-1][i]==-1 ? -1 : dp[j-1][dp[j-1][i]]);
		}
	}
}
int getKthAncestor(int u,int k){
	int d = depth[u] - k;
	if(k==0) return u;
	for(int j=l;j>=0;j--){
		int nu = dp[j][u];
		if(nu==-1) continue;
		else if(depth[nu]==d) return nu;
		else if(depth[nu]>d) u = nu;
	}
	return -1;
}
int getLCA(int a,int b){
	if(depth[a]>depth[b]) a = getKthAncestor(a,depth[a]-depth[b]);
	else if(depth[b]>depth[a]) b = getKthAncestor(b,depth[b]-depth[a]);
	if(a==b) return a;
	for(int j=l;j>=0;j--){
		int na = dp[j][a] , nb = dp[j][b];
		if(na!=-1 && nb!=-1 && na!=nb) {
			a = na , b = nb;
		}
	}
	return dp[0][a];
}
int getKthNodeInPath(int a,int b,int k){
	int u = getLCA(a,b);
	if(k<=depth[a] - depth[u]+1) return getKthAncestor(a,k-1);
	else return getKthAncestor(b,depth[b]+depth[a]-2*depth[u]-k+1);
}
ll getDistance(int a,int b){
	int u = getLCA(a,b);
	ll ans = dist[a] + dist[b] - 2*dist[u];
	return ans;
}
int main(){
//	freopen("i2","r",stdin);
	int t,n;
	string querey;
	scanf("%d",&t);
	while(t--){
//		printf("\n");
		scanf("%d",&n);
		g.clear();
		g.resize(n,vpli());
		for(int i=1;i<n;i++){
			int u,v;
			ll w;
			scanf("%d %d %lld",&u,&v,&w);
			u--,v--;
			g[u].push_back(make_pair(v,w));
			g[v].push_back(make_pair(u,w));
		}
		memset(dp,-1,sizeof(dp));
		depth[0] = 0;
		dist[0] = 0;
		dfs(0,-1);
		jump(n);
		dp[0][0] = 0;
//		cout<<getKthNodeInPath(2,3,1);
//		cout<<getDistance(4,3);
//		cout<<getLCA(2,3);
		while(cin>>querey){
			if(querey=="DONE")
				break;
			int a,b,k;
			scanf("%d%d",&a,&b);
			a--,b--;
			if(querey=="DIST"){
				printf("%lld\n",getDistance(a,b));
			}
			else{
				scanf("%d",&k);
				printf("%d\n",getKthNodeInPath(a,b,k)+1);
			}
		}
		printf("\n");
	}
	return 0;
}

