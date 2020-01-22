#include <bits/stdc++.h>

using namespace std;

int main(){
	string x;
	int d;
	cin >> x;
	int s=0;
	if(x[0]=='9')
		s++;
	for(int i=s;i<x.size();i++){
		d = x[i] - '0';
		if(d>=5){
			x[i] = 9 - d + '0';
		}
	}
	/*stringstream ss;
	long long n;
	ss << x , ss >> n;
	if(n==0)
		n+=9;*/
	cout<<x<<endl;
	return 0;
}

