#include <bits/stdc++.h>

using namespace std;

int main(){
	//freopen("i.in","r",stdin);
	int t,n;
	scanf("%d%d",&n,&t);
	string s = "";
	if(t==10){
		if(n==1){
			s = "-1";
		}
		else{
			
		s+='1';
		for(int i=0;i<n-1;i++)
			s += '0';
		}
	}
	else{
		char c = t + '0';
		for(int i=0;i<n;i++)
			s += c;
	}
	cout<<s<<endl;
	return 0;
}

