#include <bits/stdc++.h>
using namespace std;

int main(){
//	freopen("input","r",stdin);
	int n;
	scanf("%d",&n);
	int a[n];
	for(int i=0;i<n;i++){
		scanf("%d",&a[i]);
	}
	int ans = 1;
	for(int i=0;i<n;i++){
		int j = i , k = i,cnt = 1;
		while(j<n-1 && a[j]>=a[j+1]){
			j++;
		}
		while(k>=1 && a[k]>=a[k-1]){
			k--;
		}
		cnt = j-k+1;
		ans = max(ans,cnt);
	}
	printf("%d\n",ans);
	return 0;
}

