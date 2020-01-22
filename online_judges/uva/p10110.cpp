#include <bits/stdc++.h>

using namespace std;
bool isperfect(unsigned int n){
	unsigned int s = sqrt(n);
	return s*s == n;
}
int main(){
	freopen("i.in","r",stdin);
	unsigned int n;
	while(scanf("%d",&n)==1 && n!=0){
		
		string ans;
		if(isperfect(n))
			ans = "yes\n";
		else
			ans = "no\n";
			
		cout<<ans;
	}
	return 0;
}

