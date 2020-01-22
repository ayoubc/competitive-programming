#include <bits/stdc++.h>

using namespace std;

int main(){
//	freopen("i.in","r",stdin);
	int n;
	string s;
	scanf("%d",&n);
	int ans = 0;
	for(int i=1;i<=n;i++){
		cin >> s;
		if(s[0]=='X'){
			if(s[1]=='+') 
				ans++;
			else 
				ans --;
		}
		else if(s[0]=='+') 
			ans++;
		else
			ans--;
	}
	printf("%d\n",ans);
	return 0;
}

