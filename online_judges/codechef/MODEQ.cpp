#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

int MAX = 500001;
vector<vector<int> > divs(MAX, vector<int>() );

void init() {
    for(int i=1; i< MAX; i++)
        divs[i].push_back(1);

    for(int i=2; i< MAX; i++) {
        for(int j=i;j<MAX;j+=i){
            divs[j].push_back(i);
        }
    }
}


int main(){

    int t, n, m;
    init();
    scanf("%d", &t);
    for (int i=0;i<t;i++) {
        scanf("%d %d", &n, &m);

        ll ans = 0;
        for (int b=1;b<=n;b++) {
            int r = m % b;
            int xb = m - r;
            if (xb == 0) {
                ans += b - 1;
                continue;
            }

            for(auto a: divs[xb]) {
                if (a < b && (m % a) % b == r % a) {
                    ans ++;
                }
            }
        }
        printf("%lld\n", ans);
    }
    return 0;
}
