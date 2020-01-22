#include <bits/stdc++.h>
using namespace std;
string binary(int x){
	int d;
	string ans="";
	while(x){
		d = x%2;
		x/=2;
		if(d==1) ans+="1";
		else ans+="0";
	}
	return ans;
}
int main(){
//	freopen("i","r",stdin);
	int x,a=0,b=0;
	while(scanf("%d",&x)==1){
		if(x==0) break;
		string s = binary(x);
		a=0;
		b=0;
		int cnt=-1;
//		int newx = 0;
		for(int i=0;i<s.length();i++){
			if(s[i]=='1'){
//				newx |= (1<<i);
				cnt++;
				if(cnt%2==0) a |= (1<<i);
				else b |= (1<<i);
			}
		}
		cout<<a<<" "<<b<<endl;
//		cout<<newx<<endl;
	}
//	cout<<binary(x);
	return 0;
}

