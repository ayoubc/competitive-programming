#include <bits/stdc++.h>

using namespace std;

void deletevol(string &s){
	for(int i=0;i<s.size();i++){
		if(s[i]=='a' || s[i]=='e' || s[i]=='o' || s[i]=='u' || s[i]=='i' || s[i]=='y'){
			s.replace(i,1,"");
			i--;
		}
		
	}
	
}
void tolower(string &s){
	for(int i=0;i<s.size();i++){
		if(s[i]>='A' && s[i]<='Z'){
			s[i] = s[i]+32;
		}
	}
}
int main(){
	string s;
	cin >> s;
	tolower(s);
	deletevol(s);
	for(int i=0;i<s.size();i++){
		cout<<"."<<s[i];
	}
	
	return 0;
}

