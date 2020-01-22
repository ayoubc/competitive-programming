#include <bits/stdc++.h>

using namespace std;
string reverse(string s){
	int n = s.size();
	string S = "";
	for(int i=n-1;i>=0;i--){
		S += s[i];
	}
	return S;
}
bool isZCY(long long x){
	stringstream ss;
	string s;
	ss << x, ss >> s;
	int sz = s.size();
	if(sz%2==0){
		for(int i=0;i<=sz/2;i++){
			if(s[i]!=s[sz-i-1]){
				return false;
			}
		}
	}
	else{
		return false;
	}
	return true;
}
int lengh(long long x){
	int cnt = 0;
	while(x){
		cnt++;
		x/=10;
	}
	return cnt;
}
int main(){
	//freopen("i.in","r",stdin);
	int k,p,i=0;
	scanf("%d %d",&k,&p);
	long long sum = 0,x = 1;
	while(i<k){
		if(lengh(x)%2==0){
			if(isZCY(x)){
				//cout<<x<<endl;
			
				sum += x;
				sum %= p;
				i++;
				stringstream ss,sS,Ss,SS;
				string s,str;
				ss << x, ss >> s;
				int sz = s.size();
				str = s.substr(0,sz/2);
				long long d;
				sS << str , sS >> d;
				d++;
				Ss << d, Ss >> str;
				str += reverse(str);
				SS << str , SS >> x;
			}
			else x++;
		}
		else{
			x *=10;
		}
	}
	printf("%I64d\n",sum%p);
	return 0;
}

