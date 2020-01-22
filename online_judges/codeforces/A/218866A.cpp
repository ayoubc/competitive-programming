#include <bits/stdc++.h>
using namespace std;

int main(){
//	freopen("i","r",stdin);
	int n;
	scanf("%d",&n);
	vector<int> a(n);
	int ans = INT_MAX,cnt = 0;
	for(int i=0;i<n;i++){
		scanf("%d",&a[i]);
		
	}
	sort(a.begin(),a.end());
	
	for(int i=1;i<n;i++){
		ans = min(abs(a[i] - a[i-1]),ans);
	}
	for(int i=0;i<n-1;i++){
		if(a[i+1] - a[i]==ans){
			cnt++;
		}
	}
	printf("%d %d\n",ans,cnt);
	return 0;
}

