//The closer you think you're, the less you will actually see.
#include <bits/stdc++.h>

using namespace std;

int main(){
	//freopen("inp.in","r",stdin);
	int n,k,l,r;
	long long sum = 0;
	scanf("%d%d",&n,&k);
	for(int i=0;i<n;i++){
		scanf("%d%d",&l,&r);
		sum += r-l+1;
	}
	printf("%d\n",(k-sum%k)%k);
	return 0;
}

