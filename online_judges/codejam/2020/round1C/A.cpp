#include <bits/stdc++.h>

using namespace std;
typedef pair<int ,int > pi;
typedef pair<pi, int> pii;

char dirs[] = {'A', 'S', 'N', 'E', 'W'};


pi nextDir(char c, pi p1) {
    pi p;
    int i = p1.first, j = p1.second;
    if (c == 'A') p = p1;
    else if (c == 'S') p =  make_pair(i, j-1);
    else if (c == 'N') p = make_pair(i, j+1);
    else if (c == 'E') p = make_pair(i+1, j);
    else p = make_pair(i-1, j);

    return p;
}

bool eq(pi p1, pi p2) {
    return p1.first == p2.first && p1.second == p2.second;
}


int main(){
    ifstream cin ("i.txt");
    int t;
    cin >> t;
    for(int tc=1;tc<=t;tc++) {
        int x,y;
        string m;
        cin >> x>> y >> m;
        int n = m.size();
        pi intersections[n+1];
        intersections[0] = make_pair(x, y);
        for(int i=0;i<m.size();i++) {
            intersections[i+1] = nextDir(m[i], intersections[i]);
        }
        int ans = -1;

        for (int i=0;i<=n;i++) {
            int t = abs(intersections[i].first) + abs(intersections[i].second);
            if (t <= i) {
                ans = i;
                break;
            }
        }
        printf("Case #%d: ", tc);
        if (ans == -1) cout << "IMPOSSIBLE" << endl;
        else cout << ans << endl;


    }

    return 0;
}
