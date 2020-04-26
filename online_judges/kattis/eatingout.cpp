
#include <bits/stdc++.h>

using namespace std ;

int main () {
    //freopen("i.txt", "r", stdin);
    int m, a, b, c;
    cin >> m >> a >> b >> c;
    vector<int> v(m, 0);
    for(int i=0;i<a;i++) {
        v[i%m] ++;
    }
    for(int i=a;i<a+b;i++) {
        v[i%m] ++;
    }
    for(int i=a+b;i<a+b+c;i++) {
        v[i%m] ++;
    }

    bool ok = true;
    for(int i=0;i<m;i++ ) {
        if (v[i]==3) {
            ok = false;
            break;
        }
    }

    cout << (ok ? "possible" : "impossible") << endl;
    return 0;
}
