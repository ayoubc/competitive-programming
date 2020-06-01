#include <bits/stdc++.h>

using namespace std;

int main(){
    ifstream cin ("i.txt");
    int t;
    cin >> t;
    for(int tc=1;tc<=t;tc++) {

        int n;
        cin >>n;
        vector<string> v(n);
        int maxL = 0;
        string ans;
        for(int i=0;i<n;i++) {
            cin >> v[i];
            maxL = max(maxL, (int)v[i].size());
            if(maxL == v[i].size()) ans = v[i];
        }

        maxL--;

        for(int i=0;i<n;i++) {
            string str = "";
            int p = v[i].find("*");
            v[i].replace(p, 1, "");
            p--;
            for(int j=1;j<=maxL - (int)v[i].size(); j++) {
                str += "*";
                //cout << maxL - v[i].size() - 1 << endl;
                //cout << v[i] << endl;
            }

            v[i] = v[i].substr(0, p+1) + str + v[i].substr(p+1);
            //cout << v[i] << endl;
        }
        int p = ans.find("*");
        ans.replace(p, 1, "");
        //cout << ans << endl;

        bool ok = true;
        for(int i=maxL-1;i>=0;i--) {
            for(int j=0;j<n;j++) {
                if (ans[i] != v[j][i] && v[j][i] != '*') {
                    //cout << v[j] << endl;
                    ok = false;
                    break;
                }
            }
            if (!ok) break;
        }
        printf("Case #%d: ", tc);
        if(ok) {
            cout << ans << endl;
        }
        else cout << "*\n";
    }

    return 0;
}
