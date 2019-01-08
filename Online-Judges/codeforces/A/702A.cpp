#include<bits/stdc++.h>

using namespace std;
const int N = 100007;
int a[N];
int main(){
	// freopen("i","r",stdin);
	int n;
	scanf("%d",&n);
	for(int i=0;i<n;i++){
		scanf("%d",&a[i]);
	}
	int i = 0,j,ans = 0;
	while(i<n){
		j = i;
		while(j<n && a[j]<a[j+1]){
			j++;
		}
		ans = max(ans,j-i+1);
		i = j+1;
	}
	printf("%d\n",ans);
}