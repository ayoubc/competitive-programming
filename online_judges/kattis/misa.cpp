#include <bits/stdc++.h>
using namespace std;

char grid[55][55];
int r,s ;

int f(){
	int cnt = 0;
	for(int i=0;i<r;i++){
		for(int j=0;j<s;j++){
			if(grid[i][j]=='o'){
				if(i==0){
					if(j==0){
						if(grid[i][j+1]=='o')
							cnt ++;
						if(grid[i+1][j]=='o')
							cnt++;
						if(grid[i+1][j+1]=='o')
							cnt++;
					}
					else if(j==s-1){
						if(grid[i][j-1]=='o')
							cnt ++;
						if(grid[i+1][j]=='o')
							cnt++;
						if(grid[i+1][j-1]=='o')
							cnt++;
					}
					else{
						if(grid[i][j-1]=='o')
							cnt ++;
						if(grid[i][j+1]=='o')
							cnt++;
						if(grid[i+1][j]=='o')
							cnt++;
						if(grid[i+1][j+1]=='o')
							cnt++;
						if(grid[i+1][j-1]=='o')
							cnt++;
						
					}
				}
				else if(i==r-1){
					if(j==0){
						if(grid[i][j+1]=='o')
							cnt ++;
						if(grid[i-1][j]=='o')
							cnt++;
						if(grid[i-1][j+1]=='o')
							cnt++;
					}
					else if(j==s-1){
						if(grid[i][j-1]=='o')
							cnt ++;
						if(grid[i-1][j]=='o')
							cnt++;
						if(grid[i-1][j-1]=='o')
							cnt++;
					}
					else{
						if(grid[i][j-1]=='o')
							cnt ++;
						if(grid[i][j+1]=='o')
							cnt++;
						if(grid[i-1][j]=='o')
							cnt++;
						if(grid[i-1][j+1]=='o')
							cnt++;
						if(grid[i-1][j-1]=='o')
							cnt++;
						
					}
				}
				else if(j==0){
					if(grid[i+1][j]=='o')
						cnt++;
					if(grid[i-1][j]=='o')
						cnt++;
					if(grid[i][j+1]=='o')
						cnt++;
					if(grid[i-1][j+1]=='o')
						cnt++;
					if(grid[i+1][j+1]=='o')
						cnt++;
				}
				else if(j==s-1){
					if(grid[i+1][j]=='o')
						cnt++;
					if(grid[i-1][j]=='o')
						cnt++;
					if(grid[i][j-1]=='o')
						cnt++;
					if(grid[i-1][j-1]=='o')
						cnt++;
					if(grid[i+1][j-1]=='o')
						cnt++;
				}
				else{
					if(grid[i+1][j]=='o')
						cnt++;
					if(grid[i-1][j]=='o')
						cnt++;
					if(grid[i][j-1]=='o')
						cnt++;
					if(grid[i][j+1]=='o')
						cnt++;
					if(grid[i-1][j-1]=='o')
						cnt++;
					if(grid[i+1][j-1]=='o')
						cnt++;
					if(grid[i-1][j+1]=='o')
						cnt++;
					if(grid[i+1][j+1]=='o')
						cnt++;
					
				}
				
			}
			
		}
	}
	return cnt;
}
int main(){
//	freopen("i","r",stdin);
	
	scanf("%d%d",&r,&s);
	for(int i=0;i<r;i++){
		scanf("%s",&grid[i]);
	}
//	for(int i=0;i<r;i++){
//		printf("%s\n",&grid[i]);
//	}
	int I,J,cnt,ans = 0;
	bool flag = false;
	for(int i=0;i<r;i++){
		for(int j=0;j<s;j++){
			if(grid[i][j]=='.'){
//				cout<<i<<" "<<j<<endl;
				flag = true;
				cnt = 0;
				if(i==0){
					if(j==0){
						if(grid[i][j+1]=='o')
							cnt ++;
						if(grid[i+1][j]=='o')
							cnt++;
						if(grid[i+1][j+1]=='o')
							cnt++;
					}
					else if(j==s-1){
						if(grid[i][j-1]=='o')
							cnt ++;
						if(grid[i+1][j]=='o')
							cnt++;
						if(grid[i+1][j-1]=='o')
							cnt++;
						
						
					}
					else{
						if(grid[i][j-1]=='o')
							cnt ++;
						if(grid[i][j+1]=='o')
							cnt++;
						if(grid[i+1][j]=='o')
							cnt++;
						if(grid[i+1][j+1]=='o')
							cnt++;
						if(grid[i+1][j-1]=='o')
							cnt++;
						
					}
				}
				else if(i==r-1){
					if(j==0){
						if(grid[i][j+1]=='o')
							cnt ++;
						if(grid[i-1][j]=='o')
							cnt++;
						if(grid[i-1][j+1]=='o')
							cnt++;
					}
					else if(j==s-1){
						if(grid[i][j-1]=='o')
							cnt ++;
						if(grid[i-1][j]=='o')
							cnt++;
						if(grid[i-1][j-1]=='o')
							cnt++;
					}
					else{
						if(grid[i][j-1]=='o')
							cnt ++;
						if(grid[i][j+1]=='o')
							cnt++;
						if(grid[i-1][j]=='o')
							cnt++;
						if(grid[i-1][j+1]=='o')
							cnt++;
						if(grid[i-1][j-1]=='o')
							cnt++;
					}
				}
				else if(j==0){
					if(grid[i+1][j]=='o')
						cnt++;
					if(grid[i-1][j]=='o')
						cnt++;
					if(grid[i][j+1]=='o')
						cnt++;
					if(grid[i-1][j+1]=='o')
						cnt++;
					if(grid[i+1][j+1]=='o')
						cnt++;
				}
				else if(j==s-1){
					if(grid[i+1][j]=='o')
						cnt++;
					if(grid[i-1][j]=='o')
						cnt++;
					if(grid[i][j-1]=='o')
						cnt++;
					if(grid[i-1][j-1]=='o')
						cnt++;
					if(grid[i+1][j-1]=='o')
						cnt++;
				}
				else{
					if(grid[i+1][j]=='o')
						cnt++;
					if(grid[i-1][j]=='o')
						cnt++;
					if(grid[i][j-1]=='o')
						cnt++;
					if(grid[i][j+1]=='o')
						cnt++;
					if(grid[i-1][j-1]=='o')
						cnt++;
					if(grid[i+1][j-1]=='o')
						cnt++;
					if(grid[i-1][j+1]=='o')
						cnt++;
					if(grid[i+1][j+1]=='o')
						cnt++;
					
				}
//				cout<<ans<<endl;
//				cout<<cnt<<endl;
				if(ans<=cnt){
					I = i;
					J = j;
					ans = cnt;
					
//					cout<<i<<" "<<j<<endl;
				}
			}
			
		}
	}
	if(flag){
		grid[I][J] = 'o';
//		cout<<I<<" "<<J<<endl;
	}
	
	printf("%d\n",f()/2);
	return 0;
}

