#include <bits/stdc++.h>

using namespace std;


int main(){
    int t;
    cin >> t;
    for(int tt=1;tt<=t;tt++) {
        int n, d,c,m;
        cin >> n >> d >> c >> m;
        string s;
        cin >> s;
        bool ok = true;
        int index = -1;
        for(int i=0;i<n;i++) {
            if(s[i] == 'D') {
                if(d == 0) {
                    index = i;
                    break;
                }
                d--;
                c += m;
            }
            else{
                if(c == 0) {
                    index = i;
                    break;
                }
                c--;
            }
        }
        if (index != -1) {
            for (int i=index;i<n;i++) {
                if(s[i] == 'D') {
                    ok = false;
                    break;
                }
            }
        }

        printf("Case #%d: %s\n", tt, (ok  ? "YES" : "NO"));
    }
    return 0;
}
