#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const ll OO = 1e18;
ll Max(ll a,ll b){
    return (a>b ? a: b);
}
int main(){
    //freopen("i.txt","r",stdin);
    ll x,y,l,r;
    cin >> x >> y >> l >> r;
    set<ll> S;
    vector<ll> v,X,Y;
    ll num = 1;
    X.push_back(1);
    while(num<=OO/x){
        num *= x;
        X.push_back(num);
    }
    num = 1;
    Y.push_back(1);
    while(num<=OO/y){
        num *= y;
        Y.push_back(num);
    }
    for(int i=0;i<X.size();i++){
        for(int j=0;j<Y.size();j++){
            if(l-Y[j]<=X[i] && X[i]<=r-Y[j]) S.insert(X[i]+Y[j]);
        }
    }
    //cout<<X.size()<<" "<<Y.size()<<endl;
    for(set<ll>::iterator it=S.begin();it!=S.end();it++) v.push_back(*it);
    //for(int i=0;i<v.size();i++) cout<<v[i]<<" ";
    //cout<<endl;
    ll ans=0;
    if(v.size()==0) ans = r-l+1;
    else{
        ans = v[0] - l;
        for(int i=0;i<v.size()-1;i++){
            ans = Max(ans,v[i+1]-v[i]-1);
        }
        ans = Max(ans,r - v[v.size()-1]);
    }
    cout<<ans;

    return 0;
}
