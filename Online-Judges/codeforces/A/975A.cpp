//slowly but surly!
#include <bits/stdc++.h>
using namespace std;
string root(string s){
	string S = "";
	set<char> st;
	for(int i=0;i<s.size();i++){
		st.insert(s[i]);
	}
	for(set<char>::iterator it=st.begin();it!=st.end();it++){
		S += *it;
	}
	return S;
}
int main(){
	//freopen("i","r",stdin);
	int n;
	string s;
	set<string> st;
	scanf("%d",&n);
	for(int i=0;i<n;i++){
		cin>>s;
		st.insert(root(s));
	}
	printf("%d\n",(int)st.size());
	return 0;
}

