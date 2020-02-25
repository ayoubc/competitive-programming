#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
vector<ll> repr(int n, int b) {
    vector<ll> v;
    while(n) {
        v.push_back(n%b);
        n /= b;
    }

    return v;
}

ll SSD(int n, int b) {
    vector<ll> v = repr(n, b);

    ll ans = 0;
    for(int i=0;i<v.size();i++) ans += v[i]*v[i];
    return ans;
}
int main(){
    /*vector<int> v = repr(16, 3);
    for(int i=v.size()-1;i>=0;i--) cout << v[i] << " ";*/
    //freopen("i.txt","r",stdin);
    int p;
    scanf("%d",&p);
    while(p--){
        int k,n,b;
        scanf("%d %d %d",&k,&b,&n);
        printf("%d %lld\n", k, SSD(n,b));
    }
    return 0;
}
