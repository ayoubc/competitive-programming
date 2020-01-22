//slowly but surly!
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int N  = 200005;
ll a[N];
int main(){
	//freopen("i","r",stdin);
	int n,q;
	ll A;
	scanf("%d %d",&n,&q);
	for(int i=0;i<n;i++){
		scanf("%I64d",&A);
		if(i==0) a[i] = A;
		else a[i] = a[i-1] + A;
	}
	ll k;
	ll cur = 0;
	for(int i=0;i<q;i++){
		scanf("%I64d",&k);
		cur += k;
		int index = lower_bound(a,a+n,cur+1) - a;
		if(index==n){
			cur = index = 0;
		}
		printf("%d\n",n-index);
	}
	return 0;
}

