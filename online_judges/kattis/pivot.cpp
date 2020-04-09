#include <bits/stdc++.h>

using namespace std;
const int OO = 1e09;
const int N = 1e05 + 3;

int a[N];
int mark[N];
int main(){
    //freopen("i.txt", "r",stdin);
    int n;
    scanf("%d", &n);
    for(int i=0; i<n; i++){
        scanf("%d", &a[i]);
    }

    int m = a[0];
    for(int i=0; i<n ; i++) {
        mark[i] = (a[i] >= m ? 1 : 0);
        m = max(m, a[i]);
    }
    int M = OO;
    for(int i=n-1; i>=0 ; i--) {
        mark[i] -= (a[i] < M  ? 0 : 1);
        M = min(M, a[i]);
    }

    int ans = 0;
    for(int i=0; i<n ; i++) {
        if(mark[i] == 1)ans += mark[i];
    }

    printf("%d\n", ans);
    return 0;
}
