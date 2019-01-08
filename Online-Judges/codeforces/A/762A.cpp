#include <bits/stdc++.h>

using namespace std;
typedef  unsigned long long ull; 
int main(){
	ios_base::sync_with_stdio(false);
	//ifstream cin("i.txt");
	int t;
	ull n,k,cnt;
	cin>>n>>k;
	vector<ull> div;
	cnt = 0;
	for(ull i=1;i*i<=n;i++){
		if(n%i==0){
			div.push_back(i);
			if(n/i!=i) 
				div.push_back(n/i);
		}
	}
	if(div.size()<k) cout<<"-1\n";
	else{
		sort(div.begin(),div.end());
		cout<<div[k-1]<<endl;
	}
	return 0;
}

