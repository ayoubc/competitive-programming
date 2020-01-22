//slowly but surly!
#include <bits/stdc++.h>
using namespace std;
bool isVowel(char c){
	return (c=='a')||(c=='e')||(c=='i')||(c=='o')||(c=='u')||(c=='y');
}
string f(string s){
	if(isVowel(s[0])) return s+"yay";
	int index;
	for(int i=0;i<s.size();i++){
		if(isVowel(s[i])){
			index = i;
			break;
		}
	}
	string str1,str2;
	str1 = s.substr(0,index);
	str2 = s.substr(index);
	return str2+str1+"ay";
}
vector<string> split(string s){
	vector<string> v;
	istringstream iss(s);
	while(iss){
		string str;
		iss >> str;
		v.push_back(str);
	}
	return v;
}
int main(){
//	cout<<f("there");
	vector<string> v = split("i cant speak   pig  latin");
	
	for(int i=0;i<v.size()-1;i++) cout<<v[i]<<" ";
//	cout<<"hi";
//	freopen("i","r",stdin);
	string line;
//	while(getline(cin,line)){
//		vector<string> v  = split(line);
//		for(int i=0;i<v.size()-1;i++) cout<<f(v[i])<<" ";
//		cout<<"\n";
//	}
	return 0;
}

