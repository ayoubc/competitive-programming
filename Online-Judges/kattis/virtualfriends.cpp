#include <bits/stdc++.h>
using namespace std;
const int N = 100005;
int id[N],size[N];
void __init(){
	for(int i=1;i<=N;i++){
		id[i] = i;
		size[i] = 1;
	}
}

int root(int a){
	while(id[a]!=a){
		id[a] = id[id[a]];
		a = id[a];
	}
	return a;
}
void Union(int a,int b){
	int p = root(a), q = root(b);
	if(size[p]<size[q]){
		id[p] = q;
		size[q] += size[p];
		
	}
	else{
		id[q] = p;
		size[p] += size[q];
	}
}
int main(){
//	freopen("input","r",stdin);
	int t,n,cnt,p;
	string f1,f2;
	scanf("%d",&t);
	while(t--){
		scanf("%d",&n);
		__init();
		cnt = 1;
		map<string,int> r;
		for(int i=0;i<n;i++){
			cin >> f1 >> f2;
			if(r[f1]==0){
				r[f1] = cnt++;
			}
			if(r[f2]==0){
				r[f2] = cnt++;
			}
			if(root(r[f1])!=root(r[f2])){
				Union(r[f1],r[f2]);
				
			}
			p = root(r[f1]);
			printf("%d\n",size[p]);
		}
	}
	return 0;
}

