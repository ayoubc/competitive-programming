#include <bits/stdc++.h>

using namespace std;
string toStr(int x) {
    stringstream ss;
    string str;
    ss << x;
    ss >> str;
    return str;
}

int toInt(string str){
    if (str[0] == '0') return 0;
    stringstream ss;
    int d;
    ss << str;
    ss >> d;
    return d;
}
int main()
{
    int x;
    cin >> x;
    vector<int> v;
    string str = toStr(x);
    //sort(str.begin(), str.end());
    do {
        int d = toInt(str);
        if(d > x) v.push_back(d);
    }while(next_permutation(str.begin(), str.end()));

    sort(v.begin(), v.end());
    int ans = v.size() > 0 ? v[0] : 0;
    cout << ans << endl;
    return 0;
}
