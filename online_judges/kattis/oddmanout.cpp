#include <bits/stdc++.h>

using namespace std;
typedef unsigned int uint;
int main(){
	ios_base::sync_with_stdio(0);
	//ifstream cin("i.txt");
	int t,n;
	uint x;
	cin>>t;
	for(int i=1;i<=t;i++){
		cin>>n;
		uint ans = 0;
		while(n--){
			cin>>x;
			ans ^= x;
		}
		
		cout<<"Case #"<<i<<": "<<ans<<endl;
	}
	return 0;
}


