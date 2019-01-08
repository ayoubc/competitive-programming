#include <bits/stdc++.h>

using namespace std;

int main(){
	//freopen("i.in","r",stdin);
	int n,p,q,b;
	scanf("%d",&n);
	vector<int> a(n+1,0);
	scanf("%d",&p);
	for(int i=1;i<=p;i++){
		scanf("%d",&b);
		a[b] = 1;
	}
	scanf("%d",&q);
	for(int i=1;i<=q;i++){
		scanf("%d",&b);
		a[b] = 1;
	}
	for(int i=1;i<=n;i++){
		if(!a[i]){
			printf("Oh, my keyboard!\n");
			
			return 0;
		}
	}
	printf("I become the guy.\n");
	return 0;	
}

