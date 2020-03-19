#include <bits/stdc++.h>

using namespace std;

int main(){
    //ifstream cin("i.txt");
    int n,k;

    cin >> n >> k;

    vector<int> v(n);
    for(int i=0;i<n;i++) {
        cin >> v[i];
    }

    sort(v.begin(), v.end());


    queue<int> q;
    int cnt=1;
    for(int i=0;i<n;i++) {
        while(!q.empty()){
            int x = q.front();
            if(v[i] - x >= 1000) q.pop();
            else break;
        }
        q.push(v[i]);
        int need = q.size() / k + (q.size()%k ==0 ? 0 : 1 );

        if(need > cnt) cnt ++;
    }

    cout << cnt << endl;
    return 0;
}
