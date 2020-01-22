#include <bits/stdc++.h>
using namespace std;

int main(){
//	freopen("i","r",stdin);
	int c,n;
	scanf("%d%d",&n,&c);
	vector<int> w(n);
	for(int i=0;i<n;i++)
		scanf("%d",&w[i]);
//	for(int i=0;i<n;i++)
//		printf("%d ",w[i]);
//		
	int ans = 0,C,cnt=0;
	for(int i=0;i<n;i++){
		C = w[i];
		cnt = 0;
		if(C<=c){
			cnt = 1;
			for(int j=i+1;j<n;j++){
//				if(i==j) continue;
				if(C+w[j]<=c){
					C += w[j];
					cnt++;
				}
			}
		}
		
		ans = max(ans,cnt);
//		cout<<C<<" "<<ans<<endl;
	}
	printf("%d\n",ans);
	return 0;
}

