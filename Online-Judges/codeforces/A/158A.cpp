#include <bits/stdc++.h>

using namespace std;

int main(){
//	freopen("i.in","r",stdin);
	int n,k;
	int ans  = 0;
	scanf("%d %d",&n,&k);
	int a[n+1];
	for(int i=1;i<=n;i++){
		scanf("%d",&a[i]);
		if(i<=k && a[i]>0) ans++;
	}
	for(int i=k+1;i<=n;i++){
		if(a[i]==a[k] && a[i]>0) ans ++;
	}
	printf("%d\n",ans);
	return 0;
}

