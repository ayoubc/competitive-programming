#include <bits/stdc++.h>

using namespace std;
set<string> split(string s){
    
    set<string> v;
    string w="";
    for(int i=0;i<s.size();i++){
    	char c = tolower(s[i]);
    	if(c>='a' && c<='z') w+=c;
    	else{
    		if(w.size()!=0) v.insert(w);
    		w = "";
		}
	}
	if(w.size()!=0) v.insert(w);
    return v;
}
bool letter(char c){
    return (c>='a' && c<='z') || (c>='A' && c<='Z');
}
string toLower(string s){
    string S = "";
    for(int i=0;i<s.size();i++){
        if(letter(s[i])) S += tolower(s[i]);

    }
    return S;
}
int main(){
    //freopen("i","r",stdin);

    string line,text="";
    set<string> st;
    
    while(cin>>line){
        text+=" "+line;
    }
    st = split(text);
    set<string>::iterator it;
    for(it=st.begin();it!=st.end();it++) cout<<*it<<endl;
    return 0;
}
