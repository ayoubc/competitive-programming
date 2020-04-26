#include <bits/stdc++.h>

using namespace std;
typedef pair<int, int> pi;
typedef pair<pi, int> pii;
vector<pii> act;


int main(){
    int t;
    cin >> t;
    for(int k=1;k<=t;k++) {
        int n;
        cin >> n;
        act.clear();
        act.resize(n);
        for(int i=0;i<n; i++) {
            cin >> act[i].first.first >> act[i].first.second ;
            act[i].second = i;

        }

        sort(act.begin(), act.end());

        string ans(n, 'C');
        int c = 0;
        int j = 0;
        for(int i=0;i<n;i++) {
            if(c <= act[i].first.first) {
                c = act[i].first.second;
                ans[act[i].second] = 'C';
            }
            else if(j <= act[i].first.first) {
                ans[act[i].second] = 'J';
                j =  act[i].first.second;
            }
            else{
                ans = "IMPOSSIBLE";
                break;
            }
        }

        cout << "Case #"<<k<<": "<< ans << endl;
    }
    return 0;
}
