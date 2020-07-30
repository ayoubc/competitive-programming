#include <bits/stdc++.h>

using namespace std;


int main(){
    //freopen("i.txt", "r", stdin);
    int t;
    cin >> t;
    while(t--) {
        int n;
        cin >> n;
        vector<int> even, odd;

        for(int i=0;i<n;i++){
            int x;
            cin >> x;
            if (x%2 == 0) even.push_back(x);
            else odd.push_back(x);
        }

        string ans = "NO";
        if (even.size() % 2 == 0 || odd.size() % 2 == 0) ans = "YES";
        else{
            bool ok = false;
            for(int i=0;i<even.size();i++){
                for(int j=0;j<odd.size();j++){
                    if (abs(even[i] - odd[j]) == 1) {
                        ok = true;
                        break;
                    }
                }
                if(ok) break;
            }
            if (ok) ans = "YES";
        }

        cout << ans << endl;
    }
	return 0;
}
