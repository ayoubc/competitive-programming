#include <bits/stdc++.h>

using namespace std;

int main(){
	//freopen("i.in","r",stdin);
	string s;
	getline(cin,s);
	set<char> st;
	for(int i=0;s[i]!='\0';i++){
		if(s[i]!=' ' && s[i]!=',' && s[i]!='}' && s[i]!='{'){
			st.insert(s[i]);
		}
	}
	printf("%d\n",(int)st.size());
	return 0;
}

