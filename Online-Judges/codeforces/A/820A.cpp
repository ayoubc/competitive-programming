#include<bits/stdc++.h>


using namespace std;
int main(){
	// freopen("i","r",stdin);
	int c,v0,v1,a,l;
	scanf("%d%d%d%d%d",&c,&v0,&v1,&a,&l);
	int i = 1,ans = v0;
	while(ans<c){
		i++;
		ans += min(v0 + (i-1)*a - l,v1 - l);
	}
	// printf("%d %d\n",ans,c);
	printf("%d\n",i);
}