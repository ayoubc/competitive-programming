#include <bits/stdc++.h>
using namespace std;

int main(){
//	freopen("i","r",stdin);
	int n,m,a,b;
	double d = 100000000000.0;
	scanf("%d%d",&n,&m);
	for(int i=0;i<n;i++){
		scanf("%d%d",&a,&b);
		d = min(d,a*1.0/b);
	}
	printf("%.8f\n",m*d);
	return 0;
}

