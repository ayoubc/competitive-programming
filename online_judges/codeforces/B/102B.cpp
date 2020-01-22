#include <bits/stdc++.h>
using namespace std;
int sumdigit(int x){
	int cnt = 0;
	while(x){
		cnt += x%10;
		x/=10;
	}
	return cnt;
}
int main(){
	string s;
	cin >> s;
	int sum = 0,ans = 0;
	for(int i=0;i<s.size();i++){
		sum += s[i] - '0';
	}
	while(sum>9){
		ans ++;
		sum = sumdigit(sum);
	}
	if(s.size()!=1)
		ans++;
	printf("%d\n",ans);
	return 0;
}

