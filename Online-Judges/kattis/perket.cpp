//slowly but surly!
#include <bits/stdc++.h>
using namespace std;
int B[15] , S[15];
int main(){
	//freopen("i","r",stdin);
	int n;
	scanf("%d",&n);
	for(int i=0;i<n;i++){
		scanf("%d %d",&S[i],&B[i]);
	}
	int ans = INT_MAX,s,b;

	for(int subset=1;subset< (1<<n) ;subset++){
		s = 1;
		b = 0;
		for(int i=0;i<n;i++){
			if(subset & (1<<i)){
				s *= S[i];
				b += B[i];
			}
		}
		ans = min(ans, abs(s-b));
	}
	printf("%d\n",ans);
	return 0;
}

