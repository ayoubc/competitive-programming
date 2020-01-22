#include <bits/stdc++.h>

using namespace std;
typedef vector<int> vi;
int main(){
	//freopen("i.in","r",stdin);
	int n,g,a;
	scanf("%d",&n);
	vector<vi> G(n,vi());
	for(int i=0;i<n;i++){
		scanf("%d",&g);
		for(int j=0;j<g;j++){
			scanf("%d",&a);
			G[i].push_back(a);
		}
	}
	for(int i=0;i<n;i++){
		for(int j=1;j<G[i].size();j++){
			if(G[i][j]-G[i][j-1]!=1){
				printf("%d\n",j+1);
				break;
			}
		}
	}
	return 0;
}

