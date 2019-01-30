#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

ll D(int k,int n){
    map<int,ll> fac;
    for(int i=n;i>=n-k+1;i--){
        int cur = i;
        for(int j=2;j<=cur/j;j++){
            while(cur%j==0){
                //cout<<"hello"<<endl;
                cur /= j;
                fac[j]++;
            }
        }
        if(cur>1) fac[cur]++;
    }
    for(int i=1;i<=k;i++){
        int cur = i;
        for(int j=2;j<=cur/j;j++){
            while(cur%j==0){
                cur /= j;
                fac[j]--;
            }
        }
        if(cur>1) fac[cur]--;
    }
    ll p = 1;
    for(map<int,ll>::iterator it=fac.begin();it!=fac.end();it++){
        ll a = it->second;
        p *= (a+1);
    }
    return p;
}
int main(){
    freopen("i","r",stdin);
    int n,k;
    while(scanf("%d%d",&n,&k)==2){
        printf("%lld\n",D(k,n));

    }
    return 0;
}
