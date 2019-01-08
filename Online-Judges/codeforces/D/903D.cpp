#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int N = 2*100001;
ll a[N];
int main(){
    //freopen("i.txt","r",stdin);
    int n;
    scanf("%d",&n);
    for(int i=0;i<n;i++) scanf("%I64d",&a[i]);
    long double  sum = a[n-1]*1.0 , ans=0.0;
    map<ll,ll> mp;
    mp[a[n-1]]++;
    for(int i=n-2;i>=0;i--){
        ans += sum - ((n-1-i)*a[i] - mp[a[i]-1] + mp[a[i]+1]);
        sum += a[i];
        mp[a[i]]++;
    }
    cout<<fixed<<setprecision(0)<<ans;
    return 0;
}
