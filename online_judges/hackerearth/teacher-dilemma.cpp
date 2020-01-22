#include <bits/stdc++.h>

using namespace std;
const int M = 100005 , mod = 1000000000+7;

int id[M] , size[M];
int n,m,u,v;
void __init(){
	for(int i=1;i<=n;i++){
		id[i] = i;
		size[i] = 1;
	}
}

int root(int x){
	while(x!=id[x]){
		x = id[x];
	}
	return x;
}


void Union(int x,int y){
	int p = root(x) , q = root(y);
	if(size[p] < size[q]){
		id[p] = q;
		size[q] += size[p];
		size[p] = 1;
	}
	else{
		id[q] = p;
		size[p] += size[q];
		size[q] = 1;
	}
}
int main(){
//	ifstream cin("i.in");
	ios::sync_with_stdio(false);
	cin >> n >> m;
	__init();
	for(int i=1;i<=m;i++){
		cin >> u >> v;
		if(root(u)!=root(v))
			Union(u,v);
	}
	long long  ans = 1;
	for(int i=1;i<=n;i++){
//		cout<<size[i]<<" ";
		ans *= size[i];
		ans %= mod;
	}
		
	cout<<ans<<endl;
	return 0;
}

