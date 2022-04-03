#include <bits/stdc++.h>

using namespace std;


int main(){
    //freopen("i.txt", "s", stdin);
    int k;

    string s;
    cin >> k >> s;
    string ans;
    if(s.size() <= k) ans = s;
    else ans = s.substr(0, k) + "...";
    cout << ans << endl;
	return 0;
}
