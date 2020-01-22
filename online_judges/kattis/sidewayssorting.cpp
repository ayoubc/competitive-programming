#include<bits/stdc++.h>

using namespace std;
bool cmp(string s1,string s2){
	for(int i=0;i<s1.size();i++){
		if(s1[i]>='A' && s1[i]<='Z'){
			s1[i] = 'a' + s1[i] - 'A';
		}
	}
	for(int i=0;i<s2.size();i++){
		if(s2[i]>='A' && s2[i]<='Z'){
			s2[i] = 'a' + s2[i] - 'A';
		}
	}
	return s1<s2;
}
int main(){
	// freopen("i","r",stdin);
	int r,c;
	string s;
	while(scanf("%d%d",&r,&c)==2){
		if(r==0 && c==0)
			break;
		vector<string> v(c,"");
		for(int i=0;i<r;i++){
			cin >> s;
			for(int j=0;j<c;j++){
				v[j] += s[j];
			}
		}
		sort(v.begin(),v.end(),cmp);
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				cout<<v[j][i];
			}
			cout<<"\n";
		}
		cout<<"\n";
	}
	return 0;
}