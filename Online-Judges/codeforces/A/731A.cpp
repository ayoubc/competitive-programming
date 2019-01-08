#include <bits/stdc++.h>

using namespace std;

int main(){
	//freopen("i.in","r",stdin);
	char s[105];
	scanf("%s",&s);
	
	int ans = 0;
	if(abs(s[0]-'a')>12) ans += 26 - abs(s[0]-'a');
	else ans +=  abs(s[0]-'a');
	for(int i=1;s[i]!='\0';i++){
		
		if(abs(s[i]-s[i-1])>12){
			
			ans += 26 - abs(s[i]-s[i-1]);
		}
		else{
			
			ans += abs(s[i]-s[i-1]);
		}
	}
	printf("%d\n",ans);
	return 0;
}

