#include <bits/stdc++.h>
using namespace std;

int main(){
//	freopen("i","r",stdin);
	int t,k,n;
	scanf("%d",&t);
	while(t--){
		scanf("%d%d",&n,&k);
		vector<bool> vis(n+1,false);
		vector<int> x(k);
		for(int i=0;i<k;i++){
			scanf("%d",&x[i]);
			
		}
		int ans = 0;
		bool ok = false;
		while(!ok){
			ans ++;
			for(int i=0;i<k;i++){
				if(x[i] - (ans - 1)>=1){
					vis[x[i] - (ans - 1)] = true;
				}
				if(x[i] + (ans - 1)<=n){
					vis[x[i] + (ans - 1)] = true;
				}
			}
			bool flag = true;
			for(int i=1;i<=n;i++){
				if(!vis[i]){
					flag = false;
				}
			}
			ok = flag;
		}
		printf("%d\n",ans);
	}
	return 0;
}

