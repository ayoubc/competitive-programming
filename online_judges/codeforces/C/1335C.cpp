#include <bits/stdc++.h>

using namespace std;

int main(){
    //ifstream cin ("i.txt");
    int t;
    cin >> t;
    while(t--) {
        int n;
        cin >> n;
        map<int, int> mp;
        for(int i=0;i<n;i++) {
            int x;
            cin >> x;
            mp[x] ++;
        }
        int ans = 0;
        int sz = mp.size();
        for(auto p: mp) {
            //cout << p.first<< " " << p.second << endl;
            int cur;
            if (p.second >= sz + 1) cur = min(p.second, sz);
            else cur = min(p.second, sz-1);
            ans = max(ans, cur);
        }

        cout << min(ans, n/2) << endl;
    }
    return 0;
}
