#include <bits/stdc++.h>
using namespace std;
int a[200001];
int main(){
//	freopen("i","r",stdin);
	int n;
	scanf("%d",&n);
	string s;
	
	for(int i=0;i<n;i++){
		scanf("%d",&a[i]);
	}
	cin >> s;
	int i=0,j=0;
	while(j<n){
		i = j;
		while(s[i]=='1'){
			i++;
		}
		sort(a+j,a+i+1);
		j = i+1;
	}
	bool ok = true;
	for(int k=0;k<n-1;k++){
		if(a[k]>a[k+1])
			ok = false;
	}
	printf("%s",(ok?"YES":"NO"));
	return 0;
}

