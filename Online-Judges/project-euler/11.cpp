#include <bits/stdc++.h>

using namespace std;

int main(){
	freopen("input.in","r",stdin);
	int g[20][20];
	for(int i=0;i<20;i++){
		for(int j=0;j<20;j++){
			scanf("%d",&g[i][j]);
		}
	}
	int ans = 0,cnt;
	//left or right;
	for(int i=0;i<20;i++){
		for(int j=0;j<17;j++){
			cnt = 1;
			for(int k=0;k<=3;k++) cnt*g[i][j+k];
			ans = max(ans,cnt);
		}
		
	}
	//u or down 
	for(int i=0;i<17;i++){
		for(int j=0;j<20;j++){
			cnt=1;
			for(int k=0;k<=3;k++) cnt*=g[i+k][j];
			ans = max(ans,cnt);
		}
	}
	//diagonaly left;
	for(int i=0;i<16;i++){
		for(int j=0;j<16;j++){
			int cur1,cur2;
			cur1 = g[i][j]*g[i+1][j+1]*g[i+2][j+2]*g[i+3][j+3];
			cur2 = g[i][j+3]*g[i+1][j+2]*g[i+2][j+1]*g[i+3][j];
			ans = max(ans,max(cur1,cur2));
		}
	}
	printf("%d\n",ans);
	return 0;
}

