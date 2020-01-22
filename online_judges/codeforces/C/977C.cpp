//slowly but surly!
#include <bits/stdc++.h>
using namespace std;
const int N = 200005;
int a[N];
int main(){
//	freopen("i","r",stdin);
	int n,k;
	scanf("%d %d",&n,&k);
	for(int i=0;i<n;i++){
		scanf("%d",&a[i]);
	}
	sort(a,a+n);
	if(k==0){
		if(a[0]==1) printf("-1\n");
		else printf("%d\n",a[0]-1);
	}
	else{
		if(k==n) printf("%d\n",a[n-1]);
		else{
			if(a[k-1]==a[k]) printf("-1\n");
			else printf("%d\n",a[k-1]);
		}
	}
	return 0;
}

