#include<bits/stdc++.h>

using namespace std;
int ans[105][105];
int cur[2*105][105];
int main(){
	// freopen("i","r",stdin);
	int n;
	scanf("%d",&n);
	for(int i=1;i<=2*n;i++){
		for(int j=1;j<=n;j++){
			scanf("%d",&cur[i][j]);
		}
	}
	map<int,int> occ;
	for(int j=1;j<=n;j++){
		int I=-1,J=-1,val;
		map<int,int> occ;
		for(int i=1;i<=2*n;i++){
			occ[cur[i][j]]++;
		}
		for(int i=1;i<=2*n;i++){
			if(occ[cur[i][j]]==2){
				if(I!=-1){
					J = i;
				}
				else{
					I = i;
				}
			}
		}
		// ans[j][j] = val;
		if(j==1){
			for(int k=1;k<=n;k++){
				ans[1][k] = cur[I][k];
			}
			for(int k=1;k<=n;k++){
				ans[k][1] = cur[J][k];
			}
		}
		else{
			if(cur[I][j-1]==ans[j][j-1]){
				for(int k=1;k<=n;k++){
					ans[j][k] = cur[I][k];
				}
				for(int k=1;k<=n;k++){
					ans[k][j] = cur[J][k];
				}
			}
			else{
				for(int k=1;k<=n;k++){
					ans[j][k] = cur[J][k];
				}
				for(int k=1;k<=n;k++){
					ans[k][j] = cur[I][k];
				}
			}
		}
	}
	for(int i=1;i<=n;i++){
		for(int j=1;j<=n;j++){
			printf("%d ",ans[i][j]);
		}
	}
}