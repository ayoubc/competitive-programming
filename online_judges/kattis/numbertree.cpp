#include <bits/stdc++.h>

using namespace std;

int main(){
	ios_base::sync_with_stdio(0);
	//ifstream cin("i.txt");
	int h,I;
	string s;
	cin>>h>>s;
	unsigned int n = (1<<(h+1));
	//if(s==" ") cout<<n-1<<endl;continue;
	I = 1;
	for(int i=0;i<s.size();i++){
		if(s[i]=='L') I = 2*I;
		else I = 2*I + 1;
	}
	cout<<n-I<<endl;
	
	return 0;
}

