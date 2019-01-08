#include <bits/stdc++.h>

using namespace std;

int main(){
	//freopen("i.in","r",stdin);
	int n,ans = 0,officers = 0;
	scanf("%d",&n);
	int a[n];
	for(int i=0;i<n;i++) scanf("%d",&a[i]);
	
	for(int i=0;i<n;i++){
		if(a[i]==-1){
			if(officers==0) ans ++;
			else officers--;
		}
		else officers += a[i];
	}
	printf("%d\n",ans);
	return 0;
}

