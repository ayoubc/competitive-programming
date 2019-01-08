#include <bits/stdc++.h>

using namespace std;
int a[5];
void cal(int m){
	for(int i=0;i<5;i++)
		a[i] = 0;
	for(int i=1;i<=m;i++){
		a[i%5] ++;
	}
}
int main(){
//	freopen("inp.in","r",stdin);
	int n,m,M;
	//while(scanf("%d%d",&n,&m)==2){
		scanf("%d%d",&n,&m);
		cal(m);
		long long ans = 0;
		for(int i=1;i<=n;i++){
			ans += a[(5-i%5)%5];
		}
		printf("%lld\n",ans);
//	}
	
	return 0;
}

