#include <bits/stdc++.h>
using namespace std;
const int N = 1000001;
bool prime[N];
int pre[N];
int getSum(int i,int j){
	if(i==0) return pre[j];
	return pre[j] - pre[i-1];
}
int main(){
	memset(prime,true,sizeof(prime));
	
	vector<int> P;
	for(int i=2;i<N;i++){
		if(prime[i]){
			P.push_back(i);
			for(int j=2*i;j<N;j+=i){
				prime[j] = false;
			}
		}
	}
	int n = P.size();
	pre[0] = P[0];
	for(int i=1;i<n;i++) pre[i] = pre[i-1]+P[i];
	int ans=0, inter=0;
	for(int i=0;i<n;i++){
		for(int j=i+1;j<n , getSum(i,j)<=1000000;j++){
			if(binary_search(P.begin(),P.end(),getSum(i,j))){
				if(j-i+1>inter){
					inter = j-i+1;
					ans = getSum(i,j);
				}
			}
		}
	}
	printf("%d %d\n",inter ,ans);
	/*int j = lower_bound(P.begin(),P.end(),953) - P.begin();
	cout<<j;*/
	return 0;
}

