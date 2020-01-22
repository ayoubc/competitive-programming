#include <bits/stdc++.h>


using namespace std;
typedef long long ll;
const ll OO = 1e18;

ll fact(int x ) {
    ll p = 1;
    for(int i=1;i<=x;i++){
        if(p >= OO){
            return p;
        }
        p *= i;
    }
    return p;
}
int main() {
    int n;
    scanf("%d",&n);
    double ans = 0.0;

    for(int i=0;i<=n;i++){
        ans += 1.0/fact(i);
    }
    printf("%.16f", ans);
    return 0;
}
