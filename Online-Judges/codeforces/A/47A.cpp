#include<iostream>
#include<sstream>
#include<fstream>
#include<vector>
#include<algorithm>
#include<string>
#include<cmath>

using namespace std;
bool square(int x);
int main(){
	int n;
	cin>>n;
	if(square(8*n+1)){
		int s = sqrt(8*n+1);
		if((s-1)%2==0){
			cout<<"YES"<<endl;
		}
		else cout<<"NO"<<endl;
	}
	else cout<<"NO"<<endl;
	return 0;
}
bool square(int x){
	int s = sqrt(x);
	return x== s*s;
}
