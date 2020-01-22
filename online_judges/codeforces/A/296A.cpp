#include <bits/stdc++.h>

using namespace std;

int main(){
	//freopen("inp.in","r",stdin);
	int n;
	
	scanf("%d",&n);
	int a[n];
	map<int,int>mp;
	for(int i=0;i<n;i++){
		scanf("%d",&a[i]);
		mp[a[i]]++;
	}
	for(int i=0;i<n;i++){
		if(mp[a[i]]>(n+1)/2){
			printf("NO\n");
			return 0;
		}
	}
	printf("YES\n");
	return 0;
	
}

