#include <bits/stdc++.h>

using namespace  std;
const int N = 2501;
typedef long long ll;


int main(){
	// freopen("i","r",stdin);
	int  x,y,X;
	scanf("%d%d",&x,&y);
	string ans;
	X = y-1;
	if(y==0)
		ans = "No";
	else if(x!=0 && y==1)
		ans = "No";
	else if(X>x)
		ans = "No";
	else if((x - X)%2!=0)
		ans = "No";
	else
		ans = "Yes";
	cout<<ans<<endl;
}