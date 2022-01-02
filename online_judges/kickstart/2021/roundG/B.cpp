#include <bits/stdc++.h>

using namespace std;
typedef long long int64;

int64 manhatn(int x1, int y1, int x2, int y2){
    return abs(x1 - x2) + abs(y1 - y2);
}

int64 dist(int x, int y, vector<int> obj){
    if(x >= obj[0] && x <= obj[2] && y >= obj[1] && y <= obj[3]) return 0;

    if (x >= obj[0] && x <= obj[2]) {
        return min(abs(y - obj[1]), abs(y - obj[3]));
    }
    else if (y >= obj[1] && y <= obj[3]) {
        return min(abs(x - obj[0]), abs(x - obj[2]));
    }
    else{
        int64 a = min(manhatn(x, y, obj[0], obj[1]), manhatn(x, y, obj[2], obj[1]));
        int64 b = min(manhatn(x, y, obj[2], obj[3]), manhatn(x, y, obj[0], obj[3]));
        return min(a, b);
    }
}


int main(){
    int t;
    cin >> t;
    for(int tt=1;tt<=t;tt++) {
        int k;
        cin >> k;
        vector<int> x, y;
        for(int i=0;i<k;i++) {
            int x1, x2, y1, y2;
            cin >> x1 >> y1 >> x2 >> y2;
            x.push_back(x1);
            x.push_back(x2);
            y.push_back(y1);
            y.push_back(y2);
        }
        sort(x.begin(), x.end());
        sort(y.begin(), y.end());

        printf("Case #%d: %d %d\n", tt, x[x.size()/2 - 1], y[y.size()/2 - 1]);
    }
    return 0;
}
