#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
vector<string> splice(string str, int l) {
    int n = str.size();
    int r = n%l;

    vector<string> v;
    if(r!=0) {
        v.push_back(str.substr(0, n%l));
    }
    for(int i=r;i<n;i+=l) {
        v.push_back(str.substr(i,l));
    }
    return v;
}

ll toInt(string str) {
    stringstream ss;
    ll d;
    ss << str;
    ss >> d;
    return d;
}

string toStr(ll d) {
    stringstream ss;
    string str;
    ss << d;
    ss >> str;
    return str;
}
//
string increment(string str, int l, int &times) {
    string s = "";
    int rest = 1;

    for(int i=str.size()-1; i>=0;i--) {
        if (rest == 0) {
            s += str[i];
        }
        else {
            int d = str[i] - '0';
            if (d + 1>9) {
                s += '0';
                rest = 1;
            }
            else {
                d++;
                s += d + '0';
                rest = 0;
            }
        }
    }

    if (rest == 1) {
        int d = str[0] - '0';
        if (d + 1>9) {
            s += "01";
        }
        else {
            d++;
            s += d + '0';
        }
    }
    string ans = "";
    for(int i=s.size()-1; i>=0;i--) {
        ans += s[i];
    }

    if (ans.size() > l) {
        times++;
        return ans.substr(0, l);
    }
    return ans;
}

bool compare(string s1, string s2) {
    if (s1.size() == s2.size()) {
        return s1 > s2;
    }
    return s1.size() > s2.size();
}

int main(){
    //ifstream cin("i.txt");
    int l;
    string A;
    cin >> l;
    cin >> A;
    vector<string> v = splice(A, l);
    string ansl = "";
    string ans = "";
    int times = v.size();
    if(v[0].size() < l) {
        ansl = "1"+string(l-1, '0');
    }
    else {
        int i = 0;
        while (i<v.size() && (v[0] == v[i])) i++;

        //cout << st.size() << endl;
        if(i!=v.size() && compare(v[0], v[i])) {
            ansl = v[0];
        }
        else {
            ansl = increment(v[0], l, times);
        }
    }

    for(int i=1;i<=times;i++) ans += ansl;
    cout << ans << endl;


    return 0;
}
