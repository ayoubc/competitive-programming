#include <bits/stdc++.h>
using namespace std;
int two_power(int k){
	while(k&(k-1)){
		k++;
	}
	return k;
}
int sample(int k,int ans){
	int n = 0,cnt=0;
	while(n!=k){
		
		while(k-n < ans){
			ans /= 2;
			cnt++;
		}
		n += ans;
		
	}
	return cnt;
}
int main(){
	int k,ans;
	scanf("%d",&k);
	ans = two_power(k);
	printf("%d %d\n",ans,sample(k,ans));
	return 0;
}

