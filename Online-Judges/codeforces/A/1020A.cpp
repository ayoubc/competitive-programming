#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
ll llabs(ll a,ll b){
    if(a<b) return b-a;
    return a-b;
}
ll Min(ll a,ll b){
    if(a<b) return a;
    return b;
}
int main(){
    //freopen("i","r",stdin);
    ll n,h,a,b,k;
    cin >> n >> h >> a >> b >> k;
    while(k--){
        ll ta,fa,tb,fb;

        cin >>ta>>fa>>tb>>fb;
        ll ans;
        if(ta==tb) ans = abs(fa-fb);
        else{
            ans = abs(ta-tb);
            if(fa<a && fb<a) ans += 2*a - fa - fb;
            else if(fa>b && fb>b) ans += fa + fb  - 2*b;
            else ans += abs(fa-fb);
        }
        cout<<ans<<endl;
    }
    return 0;
}
