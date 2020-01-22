#include <bits/stdc++.h>
using namespace std;
int oss(int x,int n){
	if(n==0)
		return 1;
		
	int d = oss(x,n/2);
	if(n%2==0)
		return d*d;
	else
		return d*d*x;
}
int main(){
//	freopen("i","r",stdin);
	int c,k,bill,r,ans;
	scanf("%d%d",&c,&k);
	if(k==0){
		ans = c;
	}
	else{
		bill = oss(10,k);
		r = c%bill;
		if(r>=bill/2){
			ans = c+bill - r;
		}
		else{
			ans = c - r;
		}
	}
	printf("%d\n",ans);
	return 0;
}

