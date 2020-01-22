#include <bits/stdc++.h>

using namespace std;
const int N = 100007;
int a[N],p[N];
int main(){
	//freopen("i","r",stdin);
	int n;
	scanf("%d",&n);
	for(int i=0;i<n;i++) {
		scanf("%d %d",&a[i],&p[i]);
	}
	//for(int i=0;i<n;i++) printf("%d %d\n",a[i],p[i]);
	int M = p[0];
	int sum = 0;
	for(int i=0;i<n;i++){
		M = min(M,p[i]);
		sum += a[i]*M;
	}
	printf("%d\n",sum);
	return 0;
}