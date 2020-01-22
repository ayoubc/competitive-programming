#include <bits/stdc++.h>
using namespace std;
int w,h, ans,lasti,lastj;
char grid[100][100];
bool vis[100][100];
int find(int i,int j){
	int gold;
	if(i<0 || i>=h || j<0 || j>=w)
		return 0;
	if(grid[i][j]=='#' || vis[i][j])
		return 0;
	if(grid[i][j]=='G'){
		gold = 1;
	}
	else{
		gold = 0;	
	}
	vis[i][j] = true;
	if(grid[i][j-1]=='T' || grid[i][j+1]=='T' || grid[i-1][j]=='T'|| grid[i+1][j]=='T')
		return gold;
	gold += find(i,j+1)+find(i,j-1)+find(i-1,j)+find(i+1,j);
	return gold;
}
int main(){
//	freopen("input","r",stdin);
	scanf("%d%d",&w,&h);
	for(int i=0;i<h;i++){
		scanf("%s",&grid[i]);
	}
	for(int i=0;i<h;i++){
		for(int j=0;j<w;j++)
			vis[i][j] = false;
	}
	for(int i=0;i<h;i++){
		for(int j=0;j<w;j++){
			if(grid[i][j]=='P'){
				lasti = i;
				lastj = j;
			}
		}
	}
	ans = find(lasti,lastj) ;
	printf("%d\n",ans);
	return 0;
}

