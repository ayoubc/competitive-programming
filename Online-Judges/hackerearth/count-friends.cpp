#include <bits/stdc++.h>

using namespace std;
const int M = 100005;
int n,m,u,v;
int id[M] , size[M];
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

void Union(int x ,int y){
	int p = root(x) , q = root(y);
	if(size[p] < size[q]){
		id[p] = id[q];
		size[q] += size[p];
	}
	else{
		id[q] = p;
		size[p] += size[q];
	}
}
int main(){
//	ifstream cin("i.in");
//	ofstream cout("o.out");
	ios::sync_with_stdio(false);
	cin >> n >> m;
	__init();
	for(int i=0;i<m;i++){
		cin >> u >> v;
		if(root(u)!=root(v))
			Union(u,v);
	}
	
	for(int i=1;i<=n;i++)
		cout<<size[root(i)] - 1<<" ";
	return 0;
}

