#include <bits/stdc++.h>

using namespace std;
string split(string line){
	vector<string> v;
	int n;
	istringstream iss(line);
	do{
		string str;
		iss >> str;
		v.push_back(str);
	}while(iss);
	n = v.size();
	return v[n-2];
}
string tolower(string s){
	//string S = "";
	for(int i=0;i<s.size();i++){
		if(s[i]>='A' && s[i]<='Z'){
			s[i] += 32;
		}
	}
	return s;
}
int main(){
//	ifstream cin("i.in");
	int n,cases = 0;
	string line,animal;
	while(cin>>n && n!=0){
		cases++;
		map<string,int> zoo;
		set<string> st;
		cin.ignore();
		for(int i=0;i<n;i++){
			getline(cin,line);
			animal = split(line);
//			cout<<animal<<endl;
			animal = tolower(animal);
			//v.push_back(animal);
			st.insert(animal);
			zoo[animal]++;
		}
		//sort(v.begin(),v.end());
		cout<<"List "<<cases<<":\n";
		for(set<string>::iterator it=st.begin();it!=st.end();it++)
			cout<<*it<<" | "<<zoo[*it]<<endl;
	}
	return 0;
}

