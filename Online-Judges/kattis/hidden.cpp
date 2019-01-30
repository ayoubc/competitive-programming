#include<iostream>
#include <bits/stdc++.h>
#include <vector>
using namespace std;
int fin(string s,char c,int j){
	int f = string::npos;
	for(int i=j;i<s.size();i++){
		if(s[i]==c){
			return i;
		}
	}
	return f;	
}
int main(){
	//ifstream cin("i");
	//int t;
	//cin>>t;
	//for(int k=0;k<t;k++){
		string passw,mess;
		cin>>passw>>mess;
		vector<bool> vis(mess.size(),false);
		vector<int> ind;
		int f;
		
		for(int i=0;i<passw.size();i++){
			f = mess.find(passw[i]);
			while(f!=string::npos){
				if(vis[f]){
					f = fin(mess,passw[i],f+1);
				}
				else{
					vis[f] = true;
					//cout<<f<<" ";
					ind.push_back(f);
					break;
				}
			}
		}
		//cout<<endl;
		if(ind.size()!=passw.size()){
			cout<<"FAIL\n";
		}
		else{
			bool pass = true;
			for(int k=0;k<ind.size()-1;k++){
				if(ind[k]>ind[k+1]){
					pass = false;
					break;
				}
			}
			if(pass){
				cout<<"PASS\n";
			}
			else{
				cout<<"FAIL\n";
			}
		}
		
	//}
	return 0;
}

