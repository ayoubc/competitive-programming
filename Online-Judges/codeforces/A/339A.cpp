#include <bits/stdc++.h>

using namespace std;

int main(){
	//freopen("i.in","r",stdin);
	char s[105];
	scanf("%s",&s);
	vector<char> v;
	for(int i=0;s[i]!='\0';i++ ){
		if(s[i]!='+')
			v.push_back(s[i]);
	}
	sort(v.begin(),v.end());
	for(int i=0;i<v.size()-1;i++){
		printf("%c+",v[i]);
	}
	printf("%c\n",v[v.size()-1]);
	return 0;
}

