#include<bits/stdc++.h> 
using namespace std;
bool vol(char c){
	return (c=='a') || (c=='e') || (c=='i') || (c=='o') || (c=='u') || (c=='y');
}
int main(){
	// freopen("i","r",stdin);
	int n;
	scanf("%d",&n);
	string s,ans = "";
	cin >> s;
	int i= 0,j;
	while(i<n){
		if(vol(s[i])){
			ans += s[i];
			j = i;
			while(j<n && vol(s[j])){
				j++;
			}
			i = j;
		}
		else{
			ans += s[i];
			i++;
		}
		
	}
	cout<<ans<<endl;
}