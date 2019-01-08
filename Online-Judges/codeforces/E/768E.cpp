#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef pair<int,ll> pli;
const int MAXN = 1000007;
int g[65];
int s[MAXN];
map<pli,int> dp;
int grundy(pair<int,ll> s){
    if(dp.find(s)!=dp.end()) return dp[s];
    ll mask = s.second;
    int &res = dp[s];
    set<int> S;
    for(int i=1;i<=60;i++){
        if(!(mask&(1ll<<i)) && s.first>=i){
            S.insert(grundy(make_pair(s.first-i , (mask|(1ll<<i)))));
        }
    }
    while(S.count(res)>0) res++;
    return res;
}
int main(){
    //freopen("i.txt","r",stdin);
    int n;
    scanf("%d",&n);
    for(int i=0;i<n;i++){
        scanf("%d",&s[i]);
    }
    if(n==1) printf("NO\n");
    else{
        int XOR=0;
        for(int i=1;i<=60;i++){
            g[i] = grundy(make_pair(i,0));
        }
        for(int i=0;i<n;i++){
            //XOR ^= grundy(make_pair(s[i],0));
            XOR ^= g[s[i]];
        }
        if(XOR==0) printf("YES\n");
        else printf("NO\n");
    }
    return 0;
}
