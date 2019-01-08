#include <bits/stdc++.h>
using namespace std;

int main(){
	char s[2];
	scanf("%s",&s);
	int i;
	char j;
	int ans;
	i = s[1] - '0';
	j = s[0];
	if((i==8 && (j=='a' || j=='h')) || (i==1 && (j=='a' || j=='h')))
		ans = 3;
	else if(j=='a' || j=='h')
		ans = 5;
	else if(i==1 || i==8)
		ans = 5;
	else
		ans = 8;
	printf("%d\n",ans);
	return 0;
}

