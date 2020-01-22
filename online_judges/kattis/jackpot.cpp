#include <bits/stdc++.h>

using namespace std;
typedef unsigned long long ull;
const ull N = 1000000000;
ull gcd(ull a,ull b){
	if(b==0){
		return a;
	}
	return gcd(b,a%b);
}
ull lcm(vector<ull> v){
	ull ans = v[0];
	for(int i=1;i<v.size();i++){
		ans = ans*v[i]/gcd(ans,v[i]);
	}
	return ans;
}
int main(){
	ios_base::sync_with_stdio(false);
	//ifstream cin("i.txt");
	
	int n,w;
	
	cin>>n;
	while(n--){
		cin>>w;
		vector<ull> v(w);
		for(int i=0;i<w;i++)
			cin>>v[i];
		ull ans = lcm(v);
		if(ans<=N) cout<<ans<<endl;
		else cout<<"More than a billion."<<endl;
		
	}
	return 0;
}

