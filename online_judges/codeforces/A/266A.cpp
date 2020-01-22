#include <bits/stdc++.h>

using namespace std;

int main(){
	
	int n,ans = 0;
	scanf("%d",&n);
	char s[n];
	scanf("%s",&s);
	int i = 0;
	while(i<n){
		int j = i,cnt = 0;
		while(j<n && s[j]==s[i]){
			cnt ++;
			j++;
		}
		i = j;
		ans += cnt -1;
	}
	printf("%d\n",ans);
	return 0;
}

