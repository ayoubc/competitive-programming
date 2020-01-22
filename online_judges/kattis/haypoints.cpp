#include <bits/stdc++.h>
using namespace std;

int main(){
//	freopen("i","r",stdin);
	int m,n,k,ans;
	string s;
	scanf("%d%d",&m,&n);
	map<string,int> hp;
	for(int i=0;i<m;i++){
		cin >> s >> k;
		hp[s] = k;
	}
	ans = 0;
	while(cin>>s){
		if(s[0]=='.'){
			printf("%d\n",ans);
			ans = 0;
		}
		ans += hp[s];
	}
	/*for(int i=0;i<2*n;i++){
		getline(cin , s);
		cout<<s<<endl;
		//if(s[0]=='.') continue;
		/*ans = 0;
		istringstream iss;
		do{
			string str;
			iss >> str;
			ans += hp[str];
		}while(iss);
		printf("%d\n",ans);*/
//	}*
	return 0;
}

