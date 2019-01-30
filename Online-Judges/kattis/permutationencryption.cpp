#include <bits/stdc++.h>
using namespace std;

int main(){
//	freopen("i","r",stdin);
	int n,l;
	string s,S;
	while(scanf("%d",&n)==1){
		if(n==0)
			break;
		vector<int> a(n);
		for(int i=0;i<n;i++ ){
			scanf("%d",&a[i]);
		}
		cin.ignore();
		getline(cin,s);
		l = s.size();
		if(l%n!=0){
			int sz = (n-l%n)%n;
			for(int i=1;i<=sz;i++){
				s += ' ';
			}
		}
//		cout<<s<<"/"<<endl;
		int i = 0;
		S = "";
		while(i<s.size()){
			for(int j=i;j<=i+n-1;j++){
				S += s[a[j-i]+i-1];
			}
			i += n;
		}
		cout<<"'"<<S<<"'"<<endl;
	}
	return 0;
}

