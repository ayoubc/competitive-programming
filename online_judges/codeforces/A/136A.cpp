#include <bits/stdc++.h>

using namespace std;

int main(){
	//freopen("i.in","r",stdin);
	int n;
	scanf("%d",&n);
	int p[n+1],r[n+1];
	for(int i=1;i<=n;i++){
		scanf("%d",&p[i]);
		r[p[i]] = i;
	}
	for(int i=1;i<=n;i++) printf("%d ",r[i]);
	return 0;
}

