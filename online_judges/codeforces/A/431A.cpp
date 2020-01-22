#include <bits/stdc++.h>

using namespace std;

int main(){
	//freopen("i.in","r",stdin);
	int a[5];
	for(int i=1;i<=4;i++) scanf("%d",&a[i]);
	char s[100005];
	scanf("%s",&s);
	int ans = 0;
	for(int i=0;s[i]!='\0';i++){
		ans += a[s[i]-'0'];
	}
	printf("%d\n",ans);
	return 0;
}

