#include<bits/stdc++.h>

using namespace std;
typedef long long ll;
char s[205][205];
char c = 't';
bool ok(int i,int j){
	return (s[i][j]==c)&&(s[i][j+1]==c)&&(s[i][j+2]==c)&&(s[i+1][j+1]==c)&&(s[i+2][j+1]==c);
}
int main(){
	// freopen("i","r",stdin);
	int n,m;
	scanf("%d %d",&n,&m);
	for(int i=0;i<n;i++){
		scanf("%s",&s[i]);
	}
	int ans = 0;
	for(int i=0;i<n-2;i++){
		for(int j=0;j<m-2;j++){
			if(ok(i,j)){
				ans++;
			}
		}
	}
	printf("%d\n",ans);
}
