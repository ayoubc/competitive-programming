#include <bits/stdc++.h>
using namespace std;

int main(){
    //freopen("i","r",stdin);
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
    return 0;
}
