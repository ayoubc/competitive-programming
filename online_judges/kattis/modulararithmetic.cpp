#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
ll extendedEuclid(ll a,ll b,ll &x,ll &y){
    if(b==0){
        x = 1;
        y = 0;
        return a;
    }
    ll d,tmp;
    d = extendedEuclid(b,a%b,x,y);
    tmp = x;
    x = y;
    y = tmp - (a/b) * y;
    return d;
}
ll modInvers(ll a,ll n){
    ll x,y;
    ll d = extendedEuclid(a,n,x,y);
    if(d==1) return (x<0? x+n:x);
    else return -1;
}
ll operation(ll x,char c,ll y,ll n){
    ll ans;
    if(c=='*'){
        ans = (x%n * y%n)%n;
    }
    else if(c=='+'){
        ans = (x%n + y%n)%n;
    }
    else if(c=='-'){
        ans = (x%n - y%n + n)%n;
    }
    else if(c=='/'){
        ll Y = modInvers(y,n);
        if(Y==-1) ans = -1;
        else ans = (x%n * Y%n)%n;
    }
    return ans;
}
int main(){
    //freopen("i","r",stdin);
    int t;
    ll n,x,y;
    char c;
    while(scanf("%lld %d",&n,&t)==2){
        if(n==0 && t==0) break;

        for(int i=0;i<t;i++){
            cin >> x >> c >> y;
            ll ans = operation(x,c,y,n);
            printf("%lld\n",ans);
        }
    }
    /*ll x,y;
    cout<<extendedEuclid(11,8,x,y)<<endl;
    cout<<x<<" "<<y<<endl;*/
    return 0;
}
