#include <bits/stdc++.h>

using namespace std;
bool isb(int n){
	int p = 0;
	while(n%2==0){
		p++;
		n /=2;
	}
	return n == (1<<(p+1)) - 1;
}
int main(){
//	freopen("i.in","r",stdin);
	int n,ans;
	scanf("%d",&n);
	for(int i=n;i>=1;i--){
		if(n%i==0){
			if(isb(i)) {
				ans = i;
				break;
			}
		}
	}
	printf("%d\n",ans);
	return 0;
}

