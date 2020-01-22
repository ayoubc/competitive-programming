//The closer you think you're, the less you will actually see.
#include <bits/stdc++.h>

using namespace std;
const int OO = (int)1e09+7;
int main(){
	//freopen("inp.in","r",stdin);
	int n;
	
	scanf("%d",&n);
	string s;
	cin >> s;
	int x[n];
	for(int i=0;i<n;i++){
		scanf("%d",&x[i]);
	}
	int ans = OO;
	for(int i=0;i<n-1;i++){
		if((s[i]=='R' && s[i+1]=='L')){
			ans = min(ans,x[i+1]-x[i]);
		}
	}
	if(ans==OO) 
		printf("-1\n");
	else
		printf("%d\n",ans/2);
	return 0;
}

