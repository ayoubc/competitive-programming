#include <bits/stdc++.h>

using namespace std;

int main(){
	//freopen("i.in","r",stdin);
	int n,m,l,r;
	char c1,c2;
	scanf("%d %d",&n,&m);
	string s;
	cin >> s;
	for(int i=0;i<m;i++){
		cin >> l >> r >> c1 >> c2;
		l--,r--;
		for(int i=l;i<=r;i++){
			if(s[i]==c1){
				s[i] = c2;
			}
		}
	}
	cout<<s<<endl;
	return 0;
}

