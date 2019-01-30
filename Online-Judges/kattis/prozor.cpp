#include <bits/stdc++.h>
using namespace std;
char g[105][105];
int c[105][105];
int r,s,k;

int main(){
//	freopen("i","r",stdin);
	
	scanf("%d%d%d",&r,&s,&k);
	
	for(int i=0;i<r;i++){
		scanf("%s",&g[i]);
	}
	
	int flies;
	for(int i=0;i<r;i++){
		flies = 0;
		for(int j=0;j<s;j++){
			if(g[i][j]=='*'){
				flies++;
				
			}
			c[i][j] = flies; 
		}
		
	}
//	for(int i=0;i<r;i++){
//		printf("%d\n",c[i][s-2] - c[i][0]);
//		
//	}
	int ans = 0,cnt,starti,startj;
	for(int i=0;i<r-k+1;i++){
		for(int j=0;j<s-k+1;j++){
			cnt = 0;
			for(int d = i+1;d<i+k-1;d++){
				cnt += c[d][j+k-2] - c[d][j];
			}
			if(cnt>ans){
				starti = i;
				startj = j;
				ans = cnt;
			}
		}
	}
	for(int j=startj;j<=startj+k-1;j++){
		if(j==startj || j==startj+k-1)
			g[starti][j] = '+';
		else{
			g[starti][j] = '-';
		}
	}
	for(int j=startj;j<=startj+k-1;j++){
		if(j==startj || j==startj+k-1)
			g[starti+k-1][j] = '+';
		else
			g[starti+k-1][j] = '-';
		
	}
	for(int i=starti+1;i<starti+k-1;i++){
		g[i][startj] = '|';
	}
	for(int i=starti+1;i<starti+k-1;i++){
		g[i][startj+k-1] = '|';
	}
	printf("%d\n",ans);
	for(int i=0;i<r;i++)
		printf("%s\n",g[i]);
		
	return 0;
}

