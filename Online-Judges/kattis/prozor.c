#include <stdio.h>
#include <stdlib.h>

char g[105][105];
int c[105][105];
int r,s,k;

int main(){
//	freopen("i","r",stdin);
	int i,j,d;
	scanf("%d%d%d",&r,&s,&k);
	
	for(i=0;i<r;i++){
		scanf("%s",&g[i]);
	}
	
	int flies;
	for(i=0;i<r;i++){
		flies = 0;
		for(j=0;j<s;j++){
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
	for( i=0;i<r-k+1;i++){
		for( j=0;j<s-k+1;j++){
			cnt = 0;
			for( d = i+1;d<i+k-1;d++){
				cnt += c[d][j+k-2] - c[d][j];
			}
			if(cnt>ans){
				starti = i;
				startj = j;
				ans = cnt;
			}
		}
	}
	for( j=startj;j<=startj+k-1;j++){
		if(j==startj || j==startj+k-1)
			g[starti][j] = '+';
		else{
			g[starti][j] = '-';
		}
	}
	for( j=startj;j<=startj+k-1;j++){
		if(j==startj || j==startj+k-1)
			g[starti+k-1][j] = '+';
		else
			g[starti+k-1][j] = '-';
		
	}
	for( i=starti+1;i<starti+k-1;i++){
		g[i][startj] = '|';
	}
	for( i=starti+1;i<starti+k-1;i++){
		g[i][startj+k-1] = '|';
	}
	printf("%d\n",ans);
	for( i=0;i<r;i++)
		printf("%s\n",g[i]);
		
	return 0;
}

