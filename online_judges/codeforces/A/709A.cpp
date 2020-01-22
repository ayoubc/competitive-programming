#include <bits/stdc++.h>

using namespace std;

int main(){
	//freopen("i.in","r",stdin);
	int n,h,d;
	scanf("%d %d %d",&n,&h,&d);
	int a[n];
	for(int i=0;i<n;i++) scanf("%d",&a[i]);
	
	int ans = 0,sz = 0;
	for(int i=0;i<n;i++){
		if(a[i]>h) continue;
		sz += a[i];
		if(sz > d){
			ans ++;
			sz = 0;
		}
	}
	printf("%d\n",ans);
	return 0;
}

