#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
ll power(int x,int n){
    if(n==0) return 1;
    if(n==1) return x;
    ll b = power(x,n/2);
    b = b*b;
    if(n%2!=0) b = b*x;
    return  b;
}
int len(ll x){
    int p=0;
    while(x){
        x /= 10;
        p++;
    }
    return p;
}

ll f(ll x){
    int p = len(x);
    return (x-power(10,p-1)+1)*p;
}
int main(){
    //freopen("i.txt","r",stdin);
    int t;
    scanf("%d",&t);
    while(t--){
         ll n,x,y,ans;
        scanf("%I64d %I64d",&n,&x);
        int p = len(x);
        y = (power(10,p) - x)*p;
        while(y<n){
            y += f(power(10,p+1)-1);
            p++;
        }
        y -= f(power(10,p)-1);
        n -= y;
        //cout<<p<<endl;
        if(n%p!=0) ans=-1;
        else ans = n/p + power(10,p-1) - x;
        printf("%I64d\n",ans);
    }

    return 0;
}
