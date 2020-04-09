#include <bits/stdc++.h>

using namespace std;
vector<string> split(string line) {
    vector<string> v;
    istringstream iss(line);
    string str;
    while(iss >> str){
        v.push_back(str);
    }
    return v;
}
int main(){
    //freopen("i.txt", "r",stdin);
    string line;
    map<string, string> mp;
    while(getline(cin, line)){
        if(line == "") break;
        vector<string> v = split(line);
        mp[v[1]] = v[0];

    }

    string word;

    while(cin >> word) {
        string ans = (mp.find(word) != mp.end() ? mp[word] : "eh");
        cout << ans << endl;
    }
    return 0;
}
