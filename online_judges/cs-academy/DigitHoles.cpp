#include<bits/stdc++.h>
using namespace std;
int holes[10] = {1,0,0,0,0,0,1,0,2,1};
int f(int x){
	int cnt = 0,d;
	while(x){
		d = x%10;
		x/=10;
		if(d==0 || d==6 || d==9){
			cnt++;
		}
		else if(d==8){
			cnt+=2;
		}
	}
	return cnt;
}

int main(){
	freopen("i","r",stdin);
	int a,b;
	scanf("%d%d",&a,&b);
	int ans,M=-1;
	for(int x=a;x<=b;x++){
		if(f(x)>M){
			M = f(x);
			ans = x;
		}
	}
	printf("%d\n",ans);
}