//The closer you think you're, the less you will actually see.
//for every problem there is a solution wich is simple, fast and wrong.
#include <bits/stdc++.h>

using namespace std;

string decode(string s){
	string S = "";
	int n = s.size();
	for(int i=0;i<n;i++){
		if((n-i)%2==0){
			S = s[i]+S;
		}
		else{
			S += s[i];
		}
	}
	return S;
}
int main(){
	int n;
	string s;
	cin >> n;
	cin >> s;
	cout<<decode(s)<<endl;
	return 0;
}

