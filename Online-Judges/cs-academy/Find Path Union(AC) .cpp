#include <iostream>
#include <vector>
#include <algorithm>
#include <stdio.h>
#include <sstream>
#include <string>
#include <map>
#include <set>
#include <stdlib.h>
#include <cmath>
#include <math.h>
#include <time.h>
#include <bitset>
#include <queue>
#define int long long
using namespace std;
int32_t main(){
    //freopen("1.txt", "r", stdin);
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int n;
    cin >> n;
    vector<int> v(n);
    for (int i=0; i < n; i++) cin >> v[i];
    sort(v.begin(), v.end());
    queue<int> q;
    int ans = 0;
    int last = -1;
    for (int j=n-1; j >= 0; j--){
        while (!q.empty() && q.front() > v[j]){
            if (last != q.front()){
                ans++;
                q.push(q.front() / 2);
            }
            last = q.front();
            q.pop();
        }
        while (!q.empty() && q.front() == v[j]){
            q.pop();
        }
        ans++;
        q.push(v[j] / 2);
        last = v[j];
    }
    while (!q.empty() && q.front() > 0){
        if (last != q.front()){
            ans++;
            q.push(q.front() / 2);
        }
        last = q.front();
        q.pop();
    }
    cout << ans - 1 << endl;
    return 0;
}
