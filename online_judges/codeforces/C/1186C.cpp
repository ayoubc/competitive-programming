#include <bits/stdc++.h>

using namespace std ;
const int N = 1e06+3;
int pref[N];

int query(int i, int j) {
    if (i==0) return pref[j];
    return pref[j] - pref[i-1];
}

bool same_parity(int x, int y) {
    return (x%2 == 0 && y%2 == 0) || (x%2 != 0 && y%2 != 0);
}
int main () {
    //ifstream cin("i.txt");

    string a,b;
    cin >> a;
    cin >> b;
    int ones= 0;
    for(int i=0;i<b.size() ;i++) ones += b[i] - '0';
    pref[0] = a[0] - '0';
    for (int i=1;i<a.size() ;i++) {
        pref[i] = pref[i-1] + (a[i] - '0');
    }
    int ans=0;
    for(int i=0;i<a.size()-b.size()+1;i++) {
        ans += same_parity(ones, query(i, i+b.size()-1));
    }
    cout << ans << endl;
    return 0;
}
