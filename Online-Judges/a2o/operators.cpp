#include<iostream>
#include <bits/stdc++.h>
using namespace std;

int main(){
	int t,n,s;
	//ifstream cin("I");
	cin>>t;
	for(int tt=0;tt<t;tt++){
		cin>>n>>s;
		if(s>n*(n+1)/2) cout<<"Impossible\n";
		else{
			vector<int> dp((2<<(n-1)),n*(n+1)/2);
			for(int i=0;i<(2<<(n-1));i++){
				for(int j=0;j<n-1;j++){
					if((i+1)&(1<<j)) dp[i] -= 2*(j+2); 
				}
			}
			sort(dp.begin(),dp.end());
			/*for(int i=0;i<(2<<(n-1));i++){
				cout<<dp[i]<<" ";
			}
			cout<<endl;*/
			if(binary_search(dp.begin(),dp.end(),s)) cout<<"Possible\n";
			else cout<<"Impossible\n";
		}
	}
	return 0;
}

