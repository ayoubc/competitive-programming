#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 7;
char s[N];
typedef long long ll;
int Id(char c){
	return c - '0';
}
int main(){
	//freopen("i.txt","r",stdin);
	scanf("%s",&s);
	int n = strlen(s);
	int cnt = 1 , i = 0 ,j;
	ll ans = 1;
	while(i<n){
		j = i;
		while(Id(s[j])+ Id(s[j+1])==9){
			if(j==n-1)
				break;
			j++;
		}
		cnt = j-i+1;
		//cout<<cnt<<endl;
		if(cnt!=1 && cnt%2!=0) ans *= (cnt+1)/2;
		i = j+1;
	}
	cout<<ans;
	return 0;
}

