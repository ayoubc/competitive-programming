#include<stdio.h>
#include<stdlib.h>
int dp[2005][2005];
int V[2005],W[2005],items[2005];
int main(){
//	freopen("i","r",stdin);
	int n,w,c,v;
	float C;
	while(scanf("%f %d",&C,&n)==2){
		c = (int)C;
		int i;
		for(i=0;i<n;i++) scanf("%d %d",&V[i],&W[i]);
//		for(i=1;i<=c;i++) dp[0][i] = 0;
		for(i=1;i<=n;i++){
			w = W[i-1] , v = V[i-1];
			int sz;
			for(sz=1;sz<=c;sz++){
				dp[i][sz] = dp[i-1][sz];
				if(sz >= w && dp[i-1][sz-w]+v>dp[i][sz]){
					dp[i][sz] = dp[i-1][sz-w] + v;
				}
			}
		}
		int sz = c,cnt=0;
		for(i=n;i>0;i--){
			if(dp[i][sz] != dp[i-1][sz]){
				int selected = i-1;
				// printf("%d\n",selected);
				items[cnt] = selected;
				cnt++;
				sz -= W[selected];
			}
		}
		 printf("%d\n",cnt);
		 for(i=0;i<cnt;i++)
		 	printf("%d ",items[i]);
		printf("\n");
	}
	return 0;
}
