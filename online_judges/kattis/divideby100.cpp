#include <bits/stdc++.h>

using namespace std ;

int main () {
    //freopen("i.txt", "r", stdin);
    string N, M;
    cin >> N;
    cin >> M;

    int k = M.size() - 1;
    int n = N.size();
    string left = "";
    string rigth = ".";
    for (int i=0;i<n-k;i++) left += N[i];
    if (left == "") left = "0";

    int index = n-1;
    while(index >= 0 && N[index] == '0') index--;
    if (n < k) {
        for(int i=1;i<=k-n;i++) rigth += "0";
    }
    for (int i=max(0, n - k);i<=index;i++) rigth += N[i];
    string ans = left + (rigth == "." ? "" : rigth);
    cout << ans << endl;
    return 0;
}
