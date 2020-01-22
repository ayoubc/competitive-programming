#include <bits/stdc++.h>

using namespace std;
const int N = 1000001;
typedef long long ll;
int cost[26];
int getId(char c){
	return c-'a';
}
char s[N];
int main () {
//	freopen("i.txt","r",stdin);
	int t;
	scanf("%d",&t);
	while(t--){
		scanf("%s",&s);
		for(int i=0;i<26;i++) scanf("%d",&cost[i]);
		int i=0, n = strlen(s);
		while(i<n){
			int j=i+1;
			while(j<n && s[j] == '?') j++;
			if(j>=n) j--;
			if(s[i] == '?' && s[j] == '?'){
				for(int k=i;k<=j;k++) s[k] = 'a';
			}
			else if(s[i] == '?'){
				for(int k=i;k<j;k++){
					s[k] = s[j];
				}
			}
			else if(s[j] == '?'){
				for(int k=i;k<=j;k++){
					s[k] = s[i];
				}
			}
			else{
				int cos = N, letter;
				for(int k=0;k<26;k++){
					if(cos > abs(cost[getId(s[i])] - cost[k]) + abs(cost[getId(s[j])] - cost[k])){
						cos = abs(cost[getId(s[i])] - cost[k]) + abs(cost[getId(s[j])] - cost[k]);
						letter = k;
					}
				}
				for(int k=i+1;k<j;k++){
					s[k] = 'a'+letter;
				}
			}
			i = j;
			if(i==n-1) break;
		}
		ll curcost = 0;
		for(int i=0;i<n-1;i++){
			curcost += abs(cost[getId(s[i])] - cost[getId(s[i+1])]);
		}
		printf("%I64d\n",curcost);
		printf("%s\n",s);
	}
	return 0;
}

