#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
map<string, ll > mp;
map<string, pair<string, string> > r;
string founder;
const int N = 50;

bool not_child(string s) {
    return r[s].first == "" && r[s].second == "";
}
ll dfs(string s) {
    if(s == founder) return 2LL<<N;
    if(not_child(s)) return 0;
    if(mp[s]) return mp[s];
    ll res = dfs(r[s].first) / 2 + dfs(r[s].second) / 2;
    mp[s] = res;
    return res;
}

int main(){
    //ifstream cin ("i.txt");
    int n,m;
    cin >> n >> m;

    cin >> founder;

    mp[founder] = (2LL<<N);
    for(int i=0;i<n;i++){
        string child, p1, p2;
        cin >> child >> p1 >> p2;
        r[child] = make_pair(p1, p2);
    }

    string ans;
    ll M = 0;
    for(int i=0;i<m;i++){
        string claimer;
        cin >> claimer;
        ll x = dfs(claimer);
        if (M < x){
            ans = claimer;
            M = x;
        }
    }
    cout << ans << endl;
    return 0;
}
