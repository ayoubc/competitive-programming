#include <bits/stdc++.h>

using namespace std;

int main(){
//	freopen("inp.in","r",stdin);
	int n;
	scanf("%d",&n);
	string s[n];
	for(int i=0;i<n;i++){
		cin >> s[i];
	}
//	for(int i=0;i<n;i++){
//		cout<<s[i]<<endl;
//	}
	char c1 = s[0][0], c2 = s[0][1];
	
	int d1=0,d2=0;
	if(c1==c2){
		printf("NO\n");
		return 0;
	}
	for(int i=0;i<n;i++){
		if(s[i][i]==c1)
			d1++;
	}
	for(int i=0;i<n;i++){
		if(s[i][n-1-i]==c1)
			d1++;
	}
//	cout<<d1<<endl;
	if(d1!=2*n){
		printf("NO\n");
		return 0;
	}
	for(int i=0;i<n;i++){
		for(int j=0;j<n;j++){
			if(i==j) continue;
			if(j==n-1-i) continue;
			if(s[i][j]==c2)
				d2++;
		}
	}
	if(d2!=n*n-2*n+1){
		printf("NO\n");
		return 0;
	}
	//cout<<d1 <<" " <<d2<<endl;
	printf("YES\n");
	return 0;
}

