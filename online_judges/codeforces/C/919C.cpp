#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
char sets[2001][2001];
int main(){
//	freopen("i","r",stdin);
	int n,m,K;
	scanf("%d%d%d",&n,&m,&K);
	for(int i=0;i<n;i++){
		scanf("%s",&sets[i]);
	}
	
	ll ans = 0;
	if(K==1){
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(sets[i][j]=='.')
					ans++;
			}
		}
	}
	else{
		for(int i=0;i<n;i++){
		int j = 0,k,cnt;
		while(j<m){
			k = j;
			cnt = 0;
			while(sets[i][k]!='*' && k<m){
				cnt ++;
				k++;
			}
			if(cnt>=K){
				ans += cnt - K + 1;
			}
			j = k+1;
		}
	}
	for(int i=0;i<m;i++){
		int j = 0,k,cnt;
		while(j<n){
			k = j;
			cnt = 0;
			while(sets[k][i]!='*' && k<n){
				cnt ++;
				k++;
			}
			if(cnt>=K){
				ans += cnt - K + 1;
			}
			j = k+1;
		}
	}
	}
	printf("%I64d\n",ans);
//	for(int i=0;i<n;i++){
//		printf("%s\n",sets[i]);
//	}
	
	return 0;
}

