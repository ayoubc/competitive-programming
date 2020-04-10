#include <bits/stdc++.h>

using namespace std;

int main(){
    //ifstream cin("i.txt");

    int n;
    int x;
    cin >> n >> x;
    vector<int> v(n);
    for(int i=0;i<n;i++) cin >> v[i];
    sort(v.begin(), v.end());
    int ans = 0;
    for(int i=0;i<n;i++) {
        int index = upper_bound(v.begin(), v.end(), x - v[i]) - v.begin();
        //cout << index << endl;
        if( index >= i) {
            //cout<< "not found " << index << endl;
            ans++;
        }
        //else cout<< "found " << index << " " << v[i]+v[index]<< endl;
    }
    cout << ans;
    return 0;

}
