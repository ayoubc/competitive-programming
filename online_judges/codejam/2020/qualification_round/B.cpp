#include <bits/stdc++.h>

using namespace std;

int getId(char c) {
    return c - '0';
}

void addPar(string &str, int x) {
    if (x < 0) {
        for(int i=1;i<=-x;i++) {
            str += "(";
        }
    }
    else{
        for(int i=1;i<=x;i++) {
            str += ")";
        }
    }
}

int main(){
    int t;
    cin >> t;
    for(int k=1;k<=t;k++) {
        string s;
        cin >> s;
        string ans = "";
        int left = 0;
        for(int i=0;i<s.size();i++) {
            int d = getId(s[i]);
            int dif = left - d;
            addPar(ans, dif);
            ans += s[i];
            left -= dif;
        }
        addPar(ans, left);
        cout << "Case #"<<k<<": "<< ans << endl;
    }
    return 0;
}
