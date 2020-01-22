#include <bits/stdc++.h>
using namespace std;
const int N = 1005;
typedef pair<int,int> pi;
typedef pair<int,pi> pii;
double amont[N];
int K[N];
//struct  edge{
//	int dad,x,k;
//	edge(int _dad,int _x,int _k){
//		dad = _dad;
//		x = _x;
//		k = _k;
//	}
//};
pii parent[N];
void parse(int a){
	int x,par,k;
	if(a==1)
		return ;
	par = parent[a].first;
	x = parent[a].second.first;
	k = parent[a].second.second;
	if(k==0){
		amont[par] = max(amont[a]*100.0/x,amont[par]);
	}
	else if(k==1){
		amont[par] = max(sqrt(amont[a])*100.0/x,amont[par]);
	}
	parse(par);
}
int main(){
//	freopen("i","r",stdin);
	int n,u,v,x,k;
	scanf("%d",&n);

	for(int i=0;i<n-1;i++){
		scanf("%d%d%d%d",&u,&v,&x,&k);
		parent[v] = make_pair(u,make_pair(x,k));
	}
	for(int i=1;i<=n;i++){
		scanf("%d",&K[i]);
	}
	for(int i=1;i<=n;i++){
		if(K[i]!=-1){
			amont[i] = K[i]*1.0;
		}
		else{
			amont[i] = 0.0;
		}
	}
	for(int i=1;i<=n;i++){
		if(K[i]!=-1){
			parse(i);
			break;
		}
	}
	printf("%.3f\n",amont[1]);
	return 0;
}

