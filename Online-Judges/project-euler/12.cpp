#include <bits/stdc++.h>

using namespace std;
int d(int n){
	int cnt = 0;
	for(int i=1;i<=n/i;i++){
		if(n%i==0){
			cnt++;
			if(i!=n/i) cnt++;
		}
	}
	return cnt;
}
int main(){
	int n = 1;
	while(d(n*(n+1)/2)<500){
		n++;
	}
	cout<<n*(n+1)/2<<endl;
	return 0;
}

