#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int main(){
    //freopen("i.txt","r",stdin);
    ll K,P,N;
    int t;
    scanf("%d",&t);
    while(t--){
        scanf("%I64d%I64d%I64d",&K,&P,&N);
        ll ans;
        ans = (K<=P ? 0 : K-P);
        ans  *= N;
        printf("%I64d\n",ans);
    }
    return 0;
}
