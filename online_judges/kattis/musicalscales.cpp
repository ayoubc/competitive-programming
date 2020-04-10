#include <bits/stdc++.h>

using namespace std;
const int K = 7;
const int N = 12;
int dx[K] = {2,4, 5,7,9,11,12};
string notes[N] = {"A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#"};
map<string, int> MP;
map<string, int> generate_scales() {
    for(int i=0;i<N;i++) MP[notes[i]] = i;

    map<string, int> mp;
    for(int i=0;i<N;i++) {
        int x = 0;
        for(int k=0;k<K;k++) {
            int j = (i + dx[k])%N;
            x |= (1<<j);
        }
        mp[notes[i]] = x;
    }
    return mp;
}
int main(){
    //ifstream cin("i.txt");

    map<string, int> mp = generate_scales();
    int n;
    cin >> n;
    string c;
    string music="";
    int X = 0;
    for(int i=0;i<n;i++) {
        cin >> c;
        music += c;
        X |= (1<<MP[c]);
    }


    vector<string> ans;
    for(auto p: mp) {
        int res = p.second & X;
        if(X == res) ans.push_back(p.first);
    }
    if(ans.size()>0)
        for(auto str: ans) cout << str << " ";
    else cout << "none" << endl;
    return 0;
}
