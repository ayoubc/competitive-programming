#include <bits/stdc++.h>

using namespace std;

int main(){
	long long n,k,ans;
	scanf("%I64d %I64d",&n,&k);
	
	if(k<=(n+1)/2){
		ans = 2*k-1;
	}
	else{
		if(n%2==0)
			ans = 2*k-n;
		else
			ans = 2*k-n - 1;
		
	}
	printf("%I64d\n",ans);
	return 0;
}

