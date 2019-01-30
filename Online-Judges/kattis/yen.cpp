#include <bits/stdc++.h>

using namespace std;
const int n = 100005;
int main(){
	char s[n];
	scanf("%s",&s);
	map<char,int> m;
	for(int i=0;s[i]!='\0';i++){
		m[s[i]]++;
	}
	if(m['W']==m['B']) printf("1\n");
	else printf("0\n");
	return 0;
}

