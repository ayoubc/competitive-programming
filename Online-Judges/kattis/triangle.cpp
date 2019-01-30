#include <bits/stdc++.h>

using namespace std;
const int inf = 1000000000;
int main(){
	ios_base::sync_with_stdio(0);
	//ifstream cin("i.txt");
	int n,t=0;
	while(cin>>n){
		t++;
		double ans = 3.0;
		long long p = 1;
		for(int i=1;i<=n;i++){
			ans *= 3.0/2;
			if(ans>=inf){
				p += 9;
				ans /= inf;
			}
		}
		
		cout<<"Case "<<t<<": "<<(int)(log10(ans))+p<<endl;
	}
	
	return 0;
}

