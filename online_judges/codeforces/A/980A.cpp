//slowly but surly!
#include <bits/stdc++.h>
using namespace std;

int main(){
//	freopen("i","r",stdin);
	int links = 0,perls = 0;
	string s;
	cin >> s;
	for(int i=0;i<s.size();i++){
		if(s[i]=='-') links++;
		else perls++;
	}
	if(perls==0) printf("YES\n");
	else if(links%perls==0) printf("YES\n");
	else printf("NO\n");
	return 0;
}

