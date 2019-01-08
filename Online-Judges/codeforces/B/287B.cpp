#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
ll n,k;
ll f(ll x){
    return (2*k-x-1)*x/2 + 1;
}
ll getS(ll x){
    return (k*(k-1) - x*(x-1))/2;
}
int main(){
    //freopen("i.txt","r",stdin);
    scanf("%I64d %I64d",&n,&k);
    ll l = 0,r=k-1,m,res;
    if(n==1) res=0;
    else if(n-1>k*(k-1)/2) res = -1;
    else{
        while(l<=r){
            m = (l+r)/2;
            if(f(m)<n) {
                l = m+1;
            }
            else{
                res = r = m-1;
            }
        }
        res++;
    }
    printf("%I64d\n",res);
    return 0;
}
