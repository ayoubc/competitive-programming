#include<bits/stdc++.h>

using namespace std;
char s[105];
int occ[26];
int main(){
	// freopen("i","r",stdin);
	int ans=0;
	set<char> st;
	scanf("%s",&s);
	for(int i=0;i<26;i++) occ[i] = 0;
	for(int i=0;s[i]!='\0';++i){
		occ[s[i] - 'a']++;
		st.insert(s[i]);
	}
	sort(occ,occ+26);
	// for(int i=0;i<26;i++) 
	// 	cout<<occ[i]<<endl;
	if(st.size()<=2)
		ans = 0;
	else{
		int i = 0;
		for(int j=0;j<26 && i+2<st.size();j++){
			if(occ[j]!=0){
				ans += occ[j];
				i++;
			}
		}
	}
	
	printf("%d\n",ans);
}