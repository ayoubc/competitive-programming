#include<bits/stdc++.h>

using namespace std ; 
string reverse(string s){
	string S = "";
	for(int i=s.size()-1;i>=0;i--)
		S += s[i];
	return S;
}
bool cmp(string s1,string s2){
	return reverse(s1)<reverse(s2);
}
int main(){
	// freopen("i","r",stdin);
	string s;
	vector<string> V;
	bool ok = true;
	while(getline(cin,s)){
		V.push_back(s);
	}
	// for(int i=0;i<V.size();i++) cout<<V[i]<<endl;
	int i=0,j;
	while(i<(int)V.size()){
		j = i;
		vector<string> v;
		while(j<V.size()&& V[j]!=""){
			v.push_back(V[j]);
			j++;
		}
		sort(v.begin(),v.end(),cmp);
		int len = 0;
		for(int k=0;k<v.size();k++){
			len = max(len,(int)v[k].size());
		}
		for(int k=0;k<v.size();k++){
			string tmp = v[k];
			for(int l=1;l<=len - v[k].size();l++){
				tmp = " "+tmp;
			}
			v[k] = tmp;
		}
		
		for(int k=0;k<v.size();k++)
			cout<<v[k]<<endl;
		if(j!=V.size())
			cout<<"\n";
		i = j+1;
	}
	return 0;
}