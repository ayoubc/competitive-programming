//slowly but surly!
#include <bits/stdc++.h>
using namespace std;
typedef pair<int,int> pi;
int gcd(int a,int b){
	if(b==0) return a;
	return gcd(b,a%b);
}
int l,r;
bool valid(int x){
	return (x>=l && x<=r);
}
int main(){
	//freopen("i.txt","r",stdin);
	int x,y;
	scanf("%d%d%d%d",&l,&r,&x,&y);
	int ans;
	if(y%x!=0){
		ans = 0;
	}
	else{
		int n = y/x;
		int cntdiff = 0,cntsame = 0;
		for(int i=1;i*i<=n;i++){
			if(n%i==0 && gcd(i,n/i)==1 && valid(i*x) && valid((n/i)*x)){
				if(i==n/i) cntsame++;
				else cntdiff++;
			}
		}
		ans = 2*cntdiff + cntsame;
	}
	printf("%d\n",ans);
	return 0;
}

