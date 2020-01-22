#include <bits/stdc++.h>

using namespace std;

int main()
{
    ifstream cin("i.txt");
    int n;
    cin >> n;
    double ans = 0.0;
    for(int i=0;i<n;i++) {
        double y,q;
        cin >> q >> y;
        ans += q*y;
    }
    printf("%.3f", ans);
    return 0;
}
