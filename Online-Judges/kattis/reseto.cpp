//slowly but surly!
#include <bits/stdc++.h>
using namespace std;
bool prime[100005];
int main(){
//	freopen("i","r",stdin);
	int n,k;
	scanf("%d %d",&n,&k);
	fill(prime,prime+100005,true);
	int cnt = 0;
	for(int i=2;i<=n;i++){
		if(prime[i]){
			cnt++;
			if(cnt==k){
				printf("%d\n",i);
				return 0;
			}
			for(int j=2*i;j<=n;j+=i){
				if(prime[j]){
					cnt++;
					if(cnt==k) {
						printf("%d\n",j);
						return 0;
					}
				}
				prime[j] = false;
			}
		}
	}
	
	return 0;
}

