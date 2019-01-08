#include<bits/stdc++.h>

using namespace std;
string  ans[] = {"Stan wins\n","Ollie wins\n"};
int Euclid(int a,int b,int mask){
	if(b==0)
		return 1-mask;
	if(a/b>1)
		return mask;
	return Euclid(b,a-b,1-mask);
}
int main(){
	int a,b,mask;
	// freopen("i","r",stdin);
	while(scanf("%d%d",&a,&b)==2){
		if(a==0 && b==0){
			break;
		}
		if(a<b)
			swap(a,b);
		mask = Euclid(a,b,0);
		cout<<ans[mask];
	}
	
}