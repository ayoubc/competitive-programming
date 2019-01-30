#include <bits/stdc++.h>
using namespace std;
vector<int> div(int n){
	vector<int> v;
	for(int i=2;i*i<=n;i++){
		if(n%i==0){
			v.push_back(i);
			if(i!=n/i)
				v.push_back(n/i);
		}
	}
	v.push_back(1);
	return v;
}
int main(){
//	freopen("i","r",stdin);
	string s;
	cin >> s;
	int n = s.size(),i,cur = -1;
	bool ok;
	vector<int> v = div(n);
//	for(int i=0;i<v.size();i++)
//		printf("%d ",v[i]);
	sort(v.begin(),v.end());
	for(int k=0;k<v.size();k++){
		map<char,int> m0;
		for(int d=0;d<v[k];d++)
			m0[s[d]]++;
		i = v[k];
		ok = true;
		while(i<s.size()){
			map<char,int> m1;
			for(int j = i;j<i+v[k];j++)
				m1[s[j]]++;
			for(int j=i;j<i+v[k];j++){
				if(m0[s[j]]!=m1[s[j]]){
					ok = false;
					break;
				}
			}
			if(!ok){
				break;
			}
			else{
				i += v[k];
			}
		}
		if(ok){
			cur = v[k];
			break;
		}
	}
	if(cur==-1)
		printf("-1\n");
	else{
		for(int k=0;k<cur;k++){
			printf("%c",s[k]);
		}
		printf("\n");
	}
	return 0;
}

