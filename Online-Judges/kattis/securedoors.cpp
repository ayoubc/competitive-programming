#include <bits/stdc++.h>

using namespace std;

int main(){
	ios_base::sync_with_stdio(0);
	//ifstream cin("i.txt");
	int n;
	cin>>n;
	string name,action;
	map<string,int> m;
	for(int i=0;i<n;i++){
		cin>>action>>name;
		//cout<<m[name].first<<" "<<m[name].second<<endl;
		if(action == "entry"){
			if(m[name]>=1) cout<<name<<" entered (ANOMALY)\n";
			else {
				cout<<name<<" entered\n";
				m[name]++;
			}	
			
		}
		else if(action == "exit"){
			if(m[name]==0) cout<<name<<" exited (ANOMALY)\n";
			else{
				cout<<name<<" exited\n";
				m[name]--;
			}
			
		}
	}
	return 0;
}

