#include <bits/stdc++.h>
using namespace std;
const int N = 2*1e5+7;
int p[N],a[N],b[N];
set<int> C[4];
int main(void){
	//freopen("i.txt","r",stdin);
	int n,m,c;
	scanf("%d",&n);
	for(int i=0;i<n;i++){
		scanf("%d",&p[i]);
	}
	for(int i=0;i<n;i++){
		scanf("%d",&a[i]);
	}
	for(int i=0;i<n;i++){
		scanf("%d",&b[i]);
	}
	for(int i=0;i<n;i++){
		C[a[i]].insert(p[i]);
		C[b[i]].insert(p[i]);
	}
	scanf("%d",&m);
	for(int i=0;i<m;i++){
		scanf("%d",&c);
		int ans;
		if(C[c].size()==0) ans = -1;
		else{
			ans = *(C[c].begin());
			for(int j=1;j<=3;j++){
				C[j].erase(ans);
			}
		}
		printf("%d ",ans);
		//printf("%d ",c);
	}
	
	return 0;
}

