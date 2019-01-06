#include <bits/stdc++.h>

using namespace std;

int main(){
//	freopen("i.in","r",stdin);
	int n,t,c;
	scanf("%d %d %d",&t,&c,&n);
	int x[n],y[n],s[n];
	for(int i=0;i<n;i++){
		scanf("%d %d %d",&x[i],&y[i],&s[i]);
	}
	int cnt;
	
	for(int i=0;i<t;i++){
		cnt = 0;
		for(int j=0;j<n;j++){
			
			if(s[j]*(x[j]+c*i) == y[j]*c) cnt++;
		}
		printf("%d\n",cnt);
	}
	return 0;
}

