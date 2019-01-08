#include <bits/stdc++.h>
using namespace std;
typedef pair<int,int> pi;

int main(){
//	freopen("i","r",stdin);
	int t,n,L;
	scanf("%d",&t);
	while(t--){
		scanf("%d",&n);
		vector<int> r(n),ans(n),l(n);

		for(int i=0;i<n;i++){
			scanf("%d%d",&l[i],&r[i]);

		}

		int time = 0;
		for(int i=0;i<n;i++){
			if(time<=r[i]){
				ans[i] = max(time,l[i]);
				time = ans[i]+1;
			}
			else{
				ans[i] = 0;
			}
			
		}
		for(int i=0;i<n;i++){
			printf("%d ",ans[i]);
		}
		printf("\n");
//		for(int i=0;i<n;i++)
//			cout<<l[i].first<<" "<<l[i].second<<endl;
	}
	return 0;
}

