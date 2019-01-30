#include <stdio.h>
//using namespace std;
int w,h, ans,lasti,lastj;
char grid[100][100];
int vis[100][100];
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
	vis[i][j] = 1;
	if(grid[i][j-1]=='T' || grid[i][j+1]=='T' || grid[i-1][j]=='T'|| grid[i+1][j]=='T')
		return gold;
	gold += find(i,j+1)+find(i,j-1)+find(i-1,j)+find(i+1,j);
	return gold;
}
int main(){
//	freopen("input","r",stdin);
	/*FILE *fp;
	fp = fopen("input","r");*/
	scanf("%d %d",&w,&h);
	int i,j;
	for(i=0;i<h;i++){
		scanf("%s",&grid[i]);
	}
	for(i=0;i<h;i++){
		for(j=0;j<w;j++)
			vis[i][j] = 0;
	}
	for(i=0;i<h;i++){
		for(j=0;j<w;j++){
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

