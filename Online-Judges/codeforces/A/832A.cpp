//slowly but surly!
#include <bits/stdc++.h>
using namespace std;

int main(){
	long long n,k;
	scanf("%I64d %I64d",&n,&k);
	long long cnt = n/k;
	if(cnt%2!=0) printf("YES\n");
	else printf("NO\n");
	return 0;
}

