#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
int main() {
    //ifstream cin("i.txt");
    ll n,m,k,l,A,B;
    cin >> n >> m >> k >> l;
    if(m<=n) {
        A = (l+k)/m + ( (l+k)%m ==0 ? 0 : 1 );
        if(A*m<=n) cout<<A<<endl;
        else cout<<-1<<endl;
    }
    else cout<<-1<<endl;
    return 0;
}