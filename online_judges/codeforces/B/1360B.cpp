#include <bits/stdc++.h>

using namespace std;


int main(){
    //freopen("i.txt", "r", stdin);
    int t;
    cin >> t;
    while(t--) {
        int n;
        cin >> n;
        vector<int> v(n);
        for(int i=0;i<n;i++) cin >> v[i];
        sort(v.begin(), v.end());
        int ans = 10000;
        for(int i=0;i<n-1;i++) {
            ans = min(ans, v[i+1] - v[i]);
        }
        cout << ans << endl;
    }
	return 0;
}
