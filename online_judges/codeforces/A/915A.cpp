#include<bits/stdc++.h>

using namespace std;
int a[105];
int main(){
	// freopen("i","r",stdin);
	int n,k;
	scanf("%d%d",&n,&k);
	for(int i=0;i<n;i++){
		scanf("%d",&a[i]);
	}
	sort(a,a+n);
	int ans = 1;
	for(int i=n-1;i>=0;i--){
		if(k%a[i]==0){
			ans = a[i];
			break;
		}
	}
	ans = k/ans;
	printf("%d\n",ans);
}