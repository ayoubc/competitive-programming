#include <bits/stdc++.h>

using namespace std;

string solve(int x, string s, string p, string c) {
    int n = c.size();
    int d = ((int) (pow(n, 1.5) + x)) % n;
    string m(n, ' ');
    //cout << m << endl;

    m[d] = p[s.find(c[d])];

    for(int j=d-1; j>=0; j--) {
        int k = s.find(c[j]);
        int b = s.find(m[j+1]);
        for(int a=0;a<(int)s.size();a++){
            if((a ^ b) == k) {
                m[j] = p[a];
                break;
            }
        }
    }

    for(int j=n-1;j>=d+1;j--) {
        int k = s.find(c[j]);
        int b = s.find(m[(j+1) % n]);
        for(int a=0;a<(int)s.size();a++){
            if((a ^ b) == k) {
                m[j] = p[a];
                break;
            }
        }
    }

    return m;
}

int main(){
    int x;
    while (cin >> x) {
        if (x == 0) break;
        string s, p, c;
        cin >> s;
        cin >> p;
        cin >> c;
        cout << solve(x, s, p, c) << endl;
    }
    return 0;
}
