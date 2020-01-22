#include <bits/stdc++.h>
using namespace std;
char grid[205][205];
bool vis[205][205];
int main(){
//	freopen("i","r",stdin);
	int c,r;
	scanf("%d%d",&r,&c);
	for(int i=0;i<r;i++){
		scanf("%s",&grid[i]);
	}
	for(int i=0;i<r;i++){
		for(int j=0;j<c;j++){
			vis[i][j] = false;
		}
	}
	int ans = 0,i=0,j=0;
	while(grid[i][j]!='T'){
		if(vis[i][j]){
			printf("Lost\n");
			return 0;
		}
		vis[i][j] = true;
		ans++;
		if(grid[i][j]=='E')
			j++;
		else if(grid[i][j]=='W')
			j--;
		else if(grid[i][j]=='N')
			i--;
		else if(grid[i][j]=='S')
			i++;
		
		if(i<0 || i>=r|| j<0 || j>=c){
			printf("Out\n");
			return 0;
		}
	}
	printf("%d\n",ans);
	return 0;
}

