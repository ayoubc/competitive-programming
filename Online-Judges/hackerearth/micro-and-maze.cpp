#include <bits/stdc++.h>

using namespace std;
int n,m;
int A[15][15];
int seen[15][15];
void __init(int n,int m){
	for(int i=1;i<=n;i++){
		for(int j=1;j<=m;j++){
			seen[i][j] = false;
		}
	}
}
bool path(int x,int y,int n,int m){
	if(x==n && y==m)
		return true;
	if(x<1|| x>n ||y<1 || y>m)
		return false;
	if(A[x][y]==0)
		return false;
	if(seen[x][y])
		return false;
		
	seen[x][y] = true;	
	if(path(x+1,y,n,m))
		return true;
	if(path(x-1,y,n,m))
		return true;
	if(path(x,y+1,n,m))
		return true;
	if(path(x,y-1,n,m))
		return true;
	return false;
}

int main(){
//	freopen("i.in","r",stdin);
	scanf("%d %d",&n,&m);
	for(int i=1;i<=n;i++){
		for(int j=1;j<=m;j++){
			scanf("%d",&A[i][j]);
		}
	}
	cout<<(path(1,1,n,m)?"Yes":"No")<<endl;
	return 0;
}

