#include <bits/stdc++.h>
#define mp make_pair
using namespace std;

const int N = 100005;
int n,m;
int size[N],id[N];
bool seen[N];
long long cost[N];
void __init(){
	for(int i=1;i<=n;i++){
		id[i] = i;
		seen[i] = false;
		size[i] = 1;
	}
}
int root(int a){
	while(a!=id[a]){
		id[a] = id[id[a]];
		a = id[a];
	}
	return a;
}
long  long Min(long long a,long long b){
	if(a<b) return a;
	else return b;
}
void Union(int a,int b){
	int p = root(a),q = root(b);
	if(size[p]>size[q]){
		id[p] = q;
		size[p]+=size[q];
	}
	else{
		id[q] = p;
		size[q]+=size[p];
	}
}

int main(){
//	freopen("i.in","r",stdin);
	int u,v;
	scanf("%d %d",&n,&m);
	
	for(int i=1;i<=n;i++){
		scanf("%I64d",&cost[i]);
	}
	__init();
	long long  ans = 0;
	for(int i=0;i<m;i++){
		scanf("%d %d",&u,&v);
		if(root(u)!=root(v)){
			Union(u,v);
		}
	}
	for(int i=1;i<=n;i++){
		int p = root(i);
		cost[p] = Min(cost[i],cost[p]);
	}
	for(int i=1;i<=n;i++){
		int p = root(i);
		if(!seen[p]){
			seen[p] = true;
			ans += cost[p];
		}
	}
	printf("%I64d\n",ans);
	return 0;
}

