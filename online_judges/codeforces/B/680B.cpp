#include <bits/stdc++.h>
using namespace std;

int main(){
//	freopen("input","r",stdin);
	int n,a,ans,d;
	scanf("%d%d",&n,&a);
	int t[n+1];
	for(int i=1;i<=n;i++){
		scanf("%d",&t[i]);
	}
	ans = t[a];
	for(int j=1;j<=n-1;j++){
		
		if(a-j >=1 && a+j<=n){
			if(t[a-j]==1  && t[a+j]==1)
				ans += 2;
		}
		else if(a-j>=1 && t[a-j]==1)
			ans++;
		else if(a+j<=n && t[a+j]==1)
			ans++;
	}
	printf("%d\n",ans);
	return 0;
}

