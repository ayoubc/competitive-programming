#include <bits/stdc++.h>

using namespace std;

int main(){
    //ifstream cin ("i.txt");
    int t;
    cin >> t;
    while(t--) {

        int n,a,b;
        cin >> n >> a >> b;

        string ans(n, 'a');
        int cnt = b;
        vector<bool> vis(26, false);
        for(int i=0;i<a;i++) {
            if(cnt != 0) {
                for(int j=0;j<26;j++) {
                    if(!vis[j]){
                        ans[i] = 'a' + j;
                        vis[j] = true;
                        cnt --;
                        break;
                    }
                }
            }
        }
        for(int i=a;i<n;i++) {

            vector<bool> vis(26, false);
            int cnt = b;
            for(int j=i+1-a;j<=i;j++) {
                vis[ans[j] - 'a'] = true;
            }
            for(int j=0;j<26;j++) {
                cnt -= vis[j];
            }
            if (cnt < 0) {
                ans[i] = ans[i-1];
            }
            else if(cnt > 0) {
                for(int j=0;j<26;j++) {
                    if(!vis[j]) {
                        ans[i] = 'a' + j;
                        break;
                    }
                }
            }
        }
        cout << ans << endl;
    }
    return 0;
}
